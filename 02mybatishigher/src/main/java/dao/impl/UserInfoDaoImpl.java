package dao.impl;

import dao.BaseDao;
import dao.IUserInfoDao;
import entity.UserInfo;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mycom on 2018/1/30.
 */
public class UserInfoDaoImpl extends BaseDao implements IUserInfoDao {
    public UserInfo isUser(UserInfo info) throws SQLException {
        //sql语句
        String sql="select * from userinfo where uName=? and uPassword=?";
        ResultSet rs = exeQuery(sql, info.getuName(), info.getuPassword());
        //创建UserInfo
        UserInfo userinfo=null;
        if(rs!=null){
            while(rs.next()){
                userinfo=new UserInfo();
                userinfo.setuName(rs.getString("uName"));
                userinfo.setuPassword(rs.getString("uPassword"));
                userinfo.setClassName(rs.getString("className"));
            }
        }
        return userinfo;
    }

    public List<UserInfo> getUser() throws SQLException {
        String sql="select * from userinfo";
        List<UserInfo> lists=new ArrayList<UserInfo>();
        ResultSet rs = exeQuery(sql);
        if(rs!=null){
            while(rs.next()){
                UserInfo userinfo=new UserInfo();
                userinfo.setuName(rs.getString("uName"));
                userinfo.setuPassword(rs.getString("uPassword"));
                userinfo.setClassName(rs.getString("className"));
                userinfo.setuId(rs.getInt("uId"));
                userinfo.setuStatus(rs.getInt("uStatus"));
                userinfo.setuType(rs.getInt("uType"));
                lists.add(userinfo);
            }
            allClose();
        }
        return lists;
    }
}
