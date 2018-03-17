import dao.IBookDao;
import entity.Book;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mycom on 2018/2/24.
 */
public class Test20180224 {
    //智能标签foreach array
    @Test
    public void findByforEachArray(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        int[] bookids={3,10};
        List<Book> list = mapper.findByforEachArray(bookids);
        for (Book book:list) {
            System.out.println(book.getBookName());
        }
        sqlSession.close();
    }
    //智能标签foreach list
    @Test
    public void findByforEachList(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        List<Integer> listids=new ArrayList<Integer>();
        listids.add(3);
        listids.add(10);
        List<Book> list = mapper.findByforEachList(listids);
        for (Book book:list) {
            System.out.println(book.getBookName());
        }
        sqlSession.close();
    }
    //智能标签foreach list 自定义
    @Test
    public void findByforEachListBook(){
        SqlSession sqlSession = MyBatisUtil.getSession();
        IBookDao mapper = sqlSession.getMapper(IBookDao.class);
        List<Book> listbook=new ArrayList<Book>();
        Book b1=new Book();
        b1.setBookID(4);
        Book b2=new Book();
        b2.setBookID(1);
        listbook.add(b1);
        listbook.add(b2);
        List<Book> list = mapper.findByforEachListBook(listbook);
        for (Book book:list) {
            System.out.println(book.getBookName());
        }
        sqlSession.close();
    }
}
