
import Dome02.service.BookService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by 浅笑 on 2018/3/12.
 */
public class Dome01test {
    @Test
    public void t1(){
    ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext01.xml");
    BookService service=(BookService)ac.getBean("service");

   }
}