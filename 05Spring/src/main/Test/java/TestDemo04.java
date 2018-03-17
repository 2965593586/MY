
import demo04.entity.Book;
import demo04.service.IBookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by mycom on 2018/3/11.
 */
public class TestDemo04 {

    @Test
    public void t1(){
        //获取对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextdemo04.xml");
        //调用方法,这里要返回类
        IBookService bookService =(IBookService) context.getBean("bookService");
        List<Book> all = bookService.findAll();
        for (Book book:all) {
            System.out.println(book);
        }

    }



}
