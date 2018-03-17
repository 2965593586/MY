
import demo10.ISomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by mycom on 2018/3/3.
 */
public class Test20180308 {
    @Test
    public void t1(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextBefore.xml");
        ISomeService proxyService =(ISomeService) context.getBean("proxyService");
        proxyService.doSome();
    }
    //后置增强
    /*@Test
    public void t2(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextAfter.xml");
        ISomeService proxyService =(ISomeService) context.getBean("proxyService");
        proxyService.doSome();
    }*/
    //环绕增强
   /*@Test
   public void t2(){
       ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextMethod.xml");
       ISomeService proxyService =(ISomeService) context.getBean("proxyService");
       proxyService.doSome();
   }*/

   //异常增强
   /*@Test
   public void t2(){
       ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextThrows.xml");
       ISomeService proxyService =(ISomeService) context.getBean("proxyService");
       try{
           proxyService.doSome();
       }catch (Exception ex){
           ex.printStackTrace();
       }
   }*/

   //顾问
   /*@Test
   public void t2(){
       ApplicationContext context=new ClassPathXmlApplicationContext("applicationContextAdvisor.xml");
       ISomeService proxyService =(ISomeService) context.getBean("proxyService");
       proxyService.doSome();
       proxyService.doAny();
   }
*/


}
