
import demo06.Student;
import demo07.ProxySubject;
import demo07.RealSubject;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/3.
 */
public class Test20180306 {
    @Test
    public void t1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextAnnotation.xml");
        Student student =(Student) context.getBean("student");
        System.out.println(student.getCar().getColor());
    }
    //代理：静态代理和动态代理
    //静态代理
    @Test
    public void t2(){
        //创建一个真实的主题对象
        RealSubject realSubject=new RealSubject();
        //创建一个代理主题对象
        ProxySubject proxySubject=new ProxySubject();
        //将真实对象赋值给代理对象
        proxySubject.setRealSubject(realSubject);
        proxySubject.request();
    }


}
