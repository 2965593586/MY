package dao;

import entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by mycom on 2018/2/25.
 */
public interface IUserDao {
    //登录的方法
    public User login(String userCode,String userPassword);
    //修改密码
    public int updatePwd(String oldPwd,String newPwd,String userName);
    //分页  查询用户表记录数
    public int count();
    //获得用户列表集合
    public List<User> getUserList(@Param("currentPageNo") Integer currentPageNo,@Param("pageSize") Integer pageSize);

}
