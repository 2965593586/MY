import demo01.HappyService;
import demo02.Student;
import demo03.printer.Printer;
import demo03.printer.Printer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/3.
 */
public class Test20180303 {
    @Test
    public void t1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextDI.xml");
        Student service =(Student) context.getBean("service");
        System.out.println(service.getCar().getName());
    }


}
