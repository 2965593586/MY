
import demo17.IBookService;
import demo17.ISomeService;
import demo19.IUserService;
import demo21.entity.Book;
import demo21.service.IBookservice;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by mycom on 2018/3/3.
 */
public class Test20180313 {
    //JDBCtemplate测试类
    @Test
    public void t1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextJDBCTemplate.xml");
        IBookservice bookService =(IBookservice) context.getBean("bookService");
        List<Book> list = bookService.findAll();
        for (Book book:list) {
            System.out.println(book);
        }
    }
}
