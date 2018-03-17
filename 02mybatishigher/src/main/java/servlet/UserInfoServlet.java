package servlet;

import com.alibaba.fastjson.JSON;
import entity.UserInfo;
import service.UserInfoService;
import service.impl.UserInfoServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mycom on 2018/2/6.
 */
public class UserInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserInfoService service=new UserInfoServiceImpl();
        try {
            List<UserInfo> user = service.getUser();
            Map<String,Object> map=new HashMap<String,Object>();
            map.put("total",map.size());
            map.put("rows",user);
            String result = JSON.toJSONString(map);
            response.setCharacterEncoding("utf-8");
            response.getWriter().write(result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
