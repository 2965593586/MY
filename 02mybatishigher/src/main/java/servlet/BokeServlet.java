package servlet;

import com.alibaba.fastjson.JSONObject;
import demoBoKe.Test;
import entity.Cnblog;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by mycom on 2018/3/10.
 */
@WebServlet(name = "BokeServlet",urlPatterns = {"/BokeServlet"})
public class BokeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Test test=new Test();
        JSONObject jsonObject = test.jsonMaker(1);
        String str = test.SendPostCnBlog("http://www.cnblogs.com/mvc/AggSite/PostList.aspx", jsonObject);
        ArrayList<Cnblog> cnblogs = test.GetContens(str);
        request.getSession().setAttribute("cnblogs",cnblogs);
        request.getRequestDispatcher("/listTitle.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
