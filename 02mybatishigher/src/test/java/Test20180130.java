import dao.IUserInfoDao;
import dao.impl.UserInfoDaoImpl;
import entity.UserInfo;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;

/**
 * Created by mycom on 2018/1/30.
 */
public class Test20180130 {
    @Test
    public void testLogin() throws SQLException {
        IUserInfoDao user=new UserInfoDaoImpl();
        UserInfo info=new UserInfo();
        info.setuName("2");
        info.setuPassword("2");
        UserInfo login = user.isUser(info);
        if(login!=null){
            System.out.println("姓名："+info.getuName());
        }
    }
}
