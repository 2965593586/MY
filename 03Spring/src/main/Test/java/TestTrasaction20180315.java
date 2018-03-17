
import demo21.entity.Book;
import demo21.service.IBookservice;
import demo22tx.entity.StockException;
import demo22tx.service.IStockService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by mycom on 2018/3/3.
 */
public class TestTrasaction20180315 {
    //JDBCtemplate测试类
    @Test
    public void t1() throws StockException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContextdemo22tx.xml");
        IStockService stockService =(IStockService) context.getBean("stockService");
        stockService.buyStock(1,100,1,10);
    }
}
