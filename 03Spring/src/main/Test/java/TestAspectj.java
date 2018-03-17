
import demoAspectj.IUserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/12.
 */
public class TestAspectj {
    @Test
    public void t1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAspect.xml");
        IUserService service =(IUserService) context.getBean("service");
        service.select();
    }

    @Test
    public void t2(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAspect.xml");
        IUserService service =(IUserService) context.getBean("service");
        service.select();
        service.update();
        service.insert();
    }


}
