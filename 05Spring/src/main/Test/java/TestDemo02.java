
import demo02.printer.Printer;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/11.
 */
public class TestDemo02 {

    //上机示例1：依赖注入
    @Test
    public void t1(){
        //获取对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextDemo02.xml");
        //调用方法,这里要返回类
        Printer printer =(Printer) context.getBean("printer");
        printer.printer();

    }
}
