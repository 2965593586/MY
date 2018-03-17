package service;

import entity.UserInfo;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by mycom on 2018/1/30.
 */
public interface UserInfoService {
    //登录
    public UserInfo isUser(UserInfo info) throws SQLException;
    //获得所有用户
    public List<UserInfo> getUser() throws SQLException;
}
