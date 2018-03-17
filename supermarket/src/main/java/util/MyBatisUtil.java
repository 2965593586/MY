package util;


import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by mycom on 2018/2/24.
 */
public class MyBatisUtil {
    static String path="Mybatis-config.xml";//获取大配置的路径
    static InputStream is;//声明输入流
    static SqlSessionFactory factory;
    static SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
    static {
        try {
            is = Resources.getResourceAsStream(path);
            factory=builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession getSession(){
        return factory.openSession();
    }
}
