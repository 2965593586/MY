package service.impl;

import dao.IUserInfoDao;
import dao.impl.UserInfoDaoImpl;
import entity.UserInfo;
import service.UserInfoService;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mycom on 2018/1/30.
 */
public class UserInfoServiceImpl implements UserInfoService {
    //声明IUSerInfoDao
    IUserInfoDao dao=new UserInfoDaoImpl();
    public UserInfo isUser(UserInfo info) throws SQLException {

        return dao.isUser(info);
    }

    public List<UserInfo> getUser() throws SQLException {
        return dao.getUser();
    }
}
