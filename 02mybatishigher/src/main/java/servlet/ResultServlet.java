package servlet;

import com.alibaba.fastjson.JSON;
import com.sun.org.apache.xalan.internal.xsltc.compiler.sym;
import entity.ErrorT;
import entity.Result;
import entity.UserInfo;
import service.ResultService;
import service.impl.ResultServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.sym.error;

/**
 * Created by mycom on 2018/2/2.
 */
public class ResultServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取action的值
        String action=request.getParameter("action");
        //创建service层对象
        ResultService service=new ResultServiceImpl();
        if(action.equals("select")){
            //获取班级名称
            String className=request.getParameter("cName");
            System.out.println(className);
            try {
                //调用方法，得到成绩表
                List<Result> resultTable = service.getResultTable(className);
                Map<String,Object> map=new HashMap<String,Object>();
                map.put("total",map.size());
                map.put("rows",resultTable);
                PrintWriter pw = response.getWriter();
                String s = JSON.toJSONStringWithDateFormat(map,"yyyy年MM月dd日");
                pw.write(s);
                pw.flush();
                pw.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }else if(action.equals("info")){
            String cName=request.getParameter("cName");
            //获得成绩最高和最低分,平均分
            try {
                Result scoreMax = service.getMax(cName);
                Result scoreMin = service.getMin(cName);
                Result scoreAvg = service.getAvg(cName);
                //查询错题,先获得题号
                Integer tid = service.getTid(cName);
                List<ErrorT> lists=new ArrayList<ErrorT>();
                for (int i=1;i<=tid;i++){
                    ErrorT error  = service.getError(cName, i);
                    if (error.getTid()==null || error.getTid()==0 || error.getCounts()==0){
                        error.setTid(i);
                    }
                    lists.add(error);
                }
                request.getSession().setAttribute("max",scoreMax);
                request.getSession().setAttribute("min",scoreMin);
                request.getSession().setAttribute("avg",scoreAvg);
                request.getSession().setAttribute("error", lists);
                request.getRequestDispatcher("/pages/resultInfo.jsp").forward(request,response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }


    }





    /***
     * 成绩下载方法
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    public void downResult(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            doPost(request,response);
    }
}
