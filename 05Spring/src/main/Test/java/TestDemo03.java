import demo01.Person;
import demo03.ISomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/11.
 */
public class TestDemo03 {

    //上机示例1：依赖注入
    @Test
    public void t1(){
        //获取对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextauto01.xml");
        //调用方法,这里要返回类
        ISomeService service =(ISomeService) context.getBean("service");
        service.select();
        service.insert();
        service.update();
        service.delete();

    }



}
