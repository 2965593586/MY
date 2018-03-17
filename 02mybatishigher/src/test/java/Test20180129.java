import dao.IBookDao;
import entity.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import util.MyBatisUtil;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mycom on 2018/1/29.
 */
public class Test20180129 {
    //更新
    @Test
    public void t4(){
        //先写路径
        String path="Mybatis-config.xml";
        //换成InputStream
        try {
            InputStream is= Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession = factory.openSession();
            Book book=new Book();
            book.setBookName("思絮飘零");
            book.setBookAuthor("微冷的雨");
            book.setBookID(2);
            book.setBookPrice(300);
            int insert = sqlSession.update("update",book);
            sqlSession.commit();
            if(insert>0){
                System.out.println("add success");
            }else{
                System.out.println("add ");
            }
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //删除
    @Test
    public void t3(){
        //先写路径
        String path="Mybatis-config.xml";
        //换成InputStream
        try {
            InputStream is= Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession = factory.openSession();

            int delete = sqlSession.delete("del",5);
            sqlSession.commit();
            if(delete>0){
                System.out.println("delete success");
            }else{
                System.out.println("delete ");
            }
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //添加
    @Test
    public void t2(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        Book book=new Book();
        book.setBookName("未来已来");
        book.setBookAuthor("马云");
        book.setBookPrice(100);
        int insert = sqlSession.insert("insert", book);
        sqlSession.commit();
        if(insert>0){
            System.out.println("add success");
        }else{
            System.out.println("add ");
        }
        sqlSession.close();
    }

    @Test
    public void t1(){
        //先写路径
        String path="Mybatis-config.xml";
        //换成InputStream
        try {
            InputStream is= Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession = factory.openSession();
            //List<Book> list = sqlSession.selectList("findAllBooks");
            IBookDao mapper = sqlSession.getMapper(IBookDao.class);
            List<Book> list = mapper.findAllBooks();
            for (Book book:list) {
                System.out.println(book.getBookName());
            }
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //模糊查询
    @Test
    public void likeSelect(){
        //先写路径
        String path="Mybatis-config.xml";
        //换成InputStream
        try {
            InputStream is= Resources.getResourceAsStream(path);
            SqlSessionFactoryBuilder builder=new SqlSessionFactoryBuilder();
            SqlSessionFactory factory=builder.build(is);
            SqlSession sqlSession = factory.openSession();
            //List<Book> list = sqlSession.selectList("findAllBooks");
            IBookDao mapper = sqlSession.getMapper(IBookDao.class);
            List<Book> list = mapper.likeSelect("四");
            for (Book book:list) {
                System.out.println(book.getBookName());
            }
            sqlSession.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void insert(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        Book book=new Book();
        book.setBookName("未来已来");
        book.setBookAuthor("马云");
        book.setBookPrice(100);
        System.out.println(book.getBookID()+"===============");
        int insert = mapper.insert(book);
        System.out.println(book.getBookID()+"===============");
        sqlSession.commit();
    }
    //多条件查询Map
    @Test
    public void selectMultiConditionMap(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("bookName","四");
        map.put("bookPrice",30);
        List<Book> list = mapper.selectMultiConditionMap(map);
        for (Book book:list) {
            System.out.println(book.getBookName());
        }
        sqlSession.close();
    }
    //多条件查询Index
    @Test
    public void selectMultiConditionIndex(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        List<Book> list = mapper.selectMultiConditionIndex("四",30);
        for (Book book:list) {
            System.out.println(book.getBookName());
        }
        sqlSession.close();
    }
    //智能标签if
    @Test
    public void findByIf(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("bookName","四");
        map.put("bookPrice",30);
        List<Book> list = mapper.findByIf(map);
        for (Book book:list) {
            System.out.println(book.getBookName());
        }
        sqlSession.close();
    }

}
