import demo03.ISomeService;
import demoJDBC.entity.Book;
import demoJDBC.service.IBookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by mycom on 2018/3/11.
 */
public class TestDemoJDBC {

    @Test
    public void t1(){
        //获取对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextJDBCTemplate.xml");
        //调用方法,这里要返回类
        IBookService bookService =(IBookService) context.getBean("bookService");
        List<Book> all = bookService.findAll();
        for (Book book:all) {
            System.out.println(book.getBookName());
        }

    }



}
