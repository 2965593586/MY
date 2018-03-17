package servlet;

import entity.Result;
import entity.StuAnswer;
import entity.TeacherAnswer;
import entity.UserInfo;
import service.ResultService;
import service.StuAnswerService;
import service.impl.ResultServiceImpl;
import service.impl.StuAnswerServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * Created by mycom on 2018/1/31.
 */
public class StuAnswerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //首先处理乱码
        request.setCharacterEncoding("utf-8");
        //接收数据
        String stuName=request.getParameter("stuName");
        Integer rows=Integer.parseInt(request.getParameter("row"));
        Integer cols=Integer.parseInt(request.getParameter("col"));
        String className=request.getParameter("className");
        System.out.println(className);
        UserInfo user = (UserInfo) request.getSession().getAttribute("user");
        //创建接口
        StuAnswerService service=new StuAnswerServiceImpl();
        //创建一个对象
        StuAnswer stu=new StuAnswer();
        stu.setStudentName(stuName);
        stu.setClassName(className);
        stu.setDateTime(new Date());
        try {
            //判断学生是否提交过成绩，提交过就不能再提交了
            String student = service.getStudent(stuName);
            if(student==null){
            for (int i=1;i<=rows*cols;i++){
                stu.setTid(i);
                String string="";
                String[] tresult=request.getParameterValues("rchoice"+i);
                if(tresult!=null){
                    for (String str:tresult) {
                        string=string+str;
                    }
                    stu.setTresult(string);
                    System.out.println("学生成绩："+stu.getTresult());
                        //调用方法,添加学生答案
                        int rs = service.insertStuAnswer(stu);
                        if(rs>0) {
                            System.out.println("操作成功");
                        }
                    }else{
                        System.out.println("已经提交了，不能提交了");
                    }
            }
                //操作成功之后，调用方法得出成绩
                int score1 = service.getScore(stuName, stu.getClassName());
                //计算完成绩将成绩插入表中
                //创建一个对象
                Result result = new Result();
                result.setStudentName(stuName);
                result.setClassName(className);
                result.setDateTime(new Date());
                result.setScore(score1);
                //调用方法
                ResultService resultService = new ResultServiceImpl();
                int j = resultService.insertResult(result);
                if (j > 0) {
                    System.out.println("成绩添加成功");
                } else {
                    System.out.println("成绩添加失败");
                }

            }else{
                System.out.println("操作失败");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
