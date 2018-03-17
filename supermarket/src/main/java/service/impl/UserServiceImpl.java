package service.impl;

import dao.IUserDao;
import entity.Page;
import entity.User;
import org.apache.ibatis.session.SqlSession;
import service.IUserService;
import util.MyBatisUtil;

import java.util.List;

/**
 * Created by mycom on 2018/2/26.
 */
public class UserServiceImpl implements IUserService {
    public User login(String userCode, String userPassword) {
        SqlSession session = MyBatisUtil.getSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        User login = mapper.login(userCode, userPassword);
        return login;
    }

    public int updatePwd(String oldPwd, String newPwd,String userName) {
        SqlSession session = MyBatisUtil.getSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        int update = mapper.updatePwd(oldPwd, newPwd,userName);
        session.commit();
        return update;
    }

    public int count() {
        SqlSession session = MyBatisUtil.getSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        int count = mapper.count();
        return count;
    }

    public Page<User> getUserList(Integer currentPageNo, Integer pageSize) {
        SqlSession session = MyBatisUtil.getSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        List<User> userList = mapper.getUserList((currentPageNo-1)*pageSize,pageSize);
        Page<User> page=new Page<User>();
        page.setPageIndex(currentPageNo);
        page.setPageSize(pageSize);
        page.setLists(userList);
        page.setTotalSize(count());
        page.setUrl("/UserServlet?oper=pageUser");
        return page;
    }
}
