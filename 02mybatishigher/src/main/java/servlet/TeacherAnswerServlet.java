package servlet;

import entity.TeacherAnswer;
import service.TeacherAnswerService;
import service.impl.TeacherAnswerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by mycom on 2018/2/1.
 */
public class TeacherAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
        request.setCharacterEncoding("utf-8");
        //获取数据
        String className=request.getParameter("className").trim();
        String answer=request.getParameter("answer").trim();
        String[] split = answer.split(",");
        //创建老师录入的对象
        TeacherAnswer teacher=new TeacherAnswer();
        //创建service层的对象
        TeacherAnswerService service=new TeacherAnswerServiceImpl();
        teacher.setClassName(className);
        service.deleteTeacherAnswer(className);
        //循环录入成绩
        for (int i=0;i<split.length;i++){
            //i为题号
            teacher.setTid(i+1);
            teacher.setTresult(split[i]);

            service.insertTeacherAnswer(teacher);

        }
        request.getSession().setAttribute("teacher",teacher);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
