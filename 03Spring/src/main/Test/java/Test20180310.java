
import demo16.ISomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/3.
 */
public class Test20180310 {
    //正则切入点顾问
    @Test
    public void t1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextAdvisor02.xml");
        ISomeService proxyService = (ISomeService) context.getBean("proxyService");
        proxyService.doSome();
        proxyService.doAny();
    }
}
