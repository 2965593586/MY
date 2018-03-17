
import demo04.service.HelloServiceImpl;
import demo04.service.IHelloService;
import demo05.MyCollection;
import demo05.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/3.
 */
public class Test20180305 {
    @Test
    public void t1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextCon.xml");
        //这里的返回值只能是接口
        /*IHelloService service =(IHelloService) context.getBean("service");
        service.doSome();*/

        //返回的类型只能是接口
        MyCollection service =(MyCollection) context.getBean("collection");
        System.out.println(service);
        MyCollection service2 =(MyCollection) context.getBean("collection");
        System.out.println(service2);

    }


}
