import demo01.Person;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/11.
 */
public class TestDemo01 {

    //上机示例1：依赖注入
    @Test
    public void t1(){
        //获取对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextDemo01.xml");
        //调用方法,这里要返回类
        Person personZhang = (Person) context.getBean("personZhang");
        personZhang.say();
        Person personRod = (Person) context.getBean("personRod");
        personRod.say();

    }
}
