

import demoTransaction.service.IStockService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/11.
 */
public class TestDemoTransaction {

    @Test
    public void t1(){
        //获取对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextdemoTransaction.xml");
        //调用方法,这里要返回类
        IStockService stockService =(IStockService) context.getBean("stockProxyFactory");
        stockService.buyStock(1,100,2,10);

    }



}
