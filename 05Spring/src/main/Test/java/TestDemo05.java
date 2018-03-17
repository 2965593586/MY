
import demo05.service.IStockService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by mycom on 2018/3/11.
 */
public class TestDemo05 {

    @Test
    public void t1(){
        //获取对象
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextdemo05.xml");
        //调用方法,这里要返回类
        IStockService stockService =(IStockService) context.getBean("stockService");
        stockService.buyStock(1,500,2,10);

    }



}
