
import demo17.IBookService;
import demo17.ISomeService;

import demo19.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/3.
 */
public class Test20180312 {
    //默认自动代理
    @Test
    public void t1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextauto01.xml");
        ISomeService service =(ISomeService) context.getBean("service");
        service.select();
    }
    //名称自动代理
    @Test
    public void t2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextauto02.xml");
        ISomeService service =(ISomeService) context.getBean("service");
        service.select();
        IBookService bookService =(IBookService) context.getBean("bookService");
        bookService.select();
    }

    //Aspectj增强   基于注解版的增强
    @Test
    public void t3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAspectj.xml");
        IUserService service =(IUserService) context.getBean("service");
//        try {
//            service.select();
//        }catch (Exception  ex){
//            ex.printStackTrace();
//        }
//        service.delect();
        service.select();
        service.insert();
        service.update();
    }
}
