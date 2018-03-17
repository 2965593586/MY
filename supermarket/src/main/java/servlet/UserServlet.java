package servlet;

import dao.IUserDao;
import entity.Page;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import service.IUserService;
import service.impl.UserServiceImpl;
import util.MyBatisUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by mycom on 2018/2/25.
 */
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置字符集
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        //获取网页上的用户名和密码
        String userName=request.getParameter("username");
        String userpassword=request.getParameter("password");
        String oper=request.getParameter("oper");
        //创建对象
        IUserService service=new UserServiceImpl();

        if(oper.equals("login")){
            //登录
            User login = service.login(userName, userpassword);
            request.getSession().setAttribute("user",login);
            if(login!=null){
                System.out.println("登录成功");
                request.getRequestDispatcher("/pages/welcome.jsp").forward(request,response);
            }else{
                System.out.println("登录失败");
            }
        }else if(oper.equals("cancel")){
            //注销
            request.getSession().removeAttribute("user");
            request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
        }else if(oper.equals("updatePwd")){
            //获得旧密码
            String oldPassword=request.getParameter("oldPassword");
            String newPassword=request.getParameter("newPassword");
            String reNewPassword=request.getParameter("reNewPassword");
            //获得登录的用户名
            User user = (User) request.getSession().getAttribute("user");
            if(newPassword.equals(reNewPassword) && user.getUserPassword().equals(oldPassword)){
                int update = service.updatePwd(oldPassword, newPassword,user.getUserName());
                if(update>0){
                    System.out.println("修改成功");
                    request.getRequestDispatcher("/pages/login.jsp").forward(request,response);
                }else{
                    System.out.println("修改失败");
                    request.getRequestDispatcher("/pages/notsuccess.jsp").forward(request,response);
                }
            }else{
                System.out.println("修改失败");
                request.getRequestDispatcher("/pages/notsuccess.jsp").forward(request,response);
            }

        }else if (oper.equals("pageUser")){
            System.out.println("进入");
            String currentNo=request.getParameter("pageIndex");
            if(currentNo==null){
                currentNo="1";
            }
            Page<User> userList = service.getUserList(Integer.parseInt(currentNo), 3);
            System.out.println("长度为========="+userList.getLists().size());
            request.setAttribute("pager",userList);
            //转发
            request.getRequestDispatcher("/pages/userList.jsp").forward(request,response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
