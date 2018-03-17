package servlet;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import entity.News;
import entity.Page;
import entity.Talk;
import service.INewsService;
import service.impl.NewsServiceImpl;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

/**
 * Created by mycom on 2018/3/1.
 */
@WebServlet(name = "NewsServlet",urlPatterns = "/NewsServlet")
public class NewsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        INewsService service=new NewsServiceImpl();

        String oper=request.getParameter("oper");
        System.out.println(oper);
        if(oper.equals("page")){
            Integer pageIndex=Integer.parseInt(request.getParameter("pageIndex"));
            if(pageIndex==null){
                pageIndex=1;
            }
            Page<News> newsList = service.getNewsList(pageIndex, 3);;
            String json = JSON.toJSONString(newsList.getLists());
            PrintWriter pw = response.getWriter();
            pw.write(json);
            pw.flush();
            pw.close();
        }else if(oper.equals("click")){
            System.out.println("=========");
            //接受要增加的id
            String newsId=request.getParameter("newsId");
            System.out.println(newsId);
            News newsInfo = service.getNewsInfo(Integer.parseInt(newsId));
            int i = service.clickCount(Integer.parseInt(newsId));
            request.getSession().setAttribute("newsInfo",newsInfo);
            System.out.println(newsInfo.getTalks());
            request.getRequestDispatcher("/pages/NewsInfo.jsp").forward(request,response);
        }else if (oper.equals("talk")){
            //向数据库提交评论的内容并且评论数量+1
            News newsInfo =(News) request.getSession().getAttribute("newsInfo");
            Integer newsId = newsInfo.getNewsId();
            String content=request.getParameter("talkContent");
            Talk talk=new Talk();
            talk.setContent(content);
            talk.setNid(newsId);
            talk.setTalkTime(new Date());
            int i = service.submitTalk(talk);
            /*String success=JSON.toJSONString("评论成功");
            PrintWriter pw = response.getWriter();
            pw.write(success);
            pw.flush();
            pw.close();*/
            request.getRequestDispatcher("/pages/newsList.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
