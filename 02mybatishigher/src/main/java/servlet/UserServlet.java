package servlet;

import dao.IUserInfoDao;
import dao.impl.UserInfoDaoImpl;
import entity.UserInfo;
import service.UserInfoService;
import service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created by mycom on 2018/1/30.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
        request.setCharacterEncoding("utf-8");
        //获取用户名和密码
        String uName=request.getParameter("uName");
        String uPassword=request.getParameter("uPassword");
        //创建UserInfoService
        UserInfoService user=new UserInfoServiceImpl();
        //实例对象
        UserInfo info=new UserInfo();
        info.setuName(uName);
        info.setuPassword(uPassword);
        //调用方法
        try {
            UserInfo login = user.isUser(info);
            if(login!=null){
                if(login.getuName()!=null){
                    //将用户保存到session
                    request.getSession().setAttribute("user",login);
                    //成功的话转发到欢迎页
                    request.getRequestDispatcher("/pages/Index.jsp").forward(request,response);
                }
            }else{
                //失败重定向到登录页面
                response.sendRedirect(request.getContextPath()+"/pages/login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
