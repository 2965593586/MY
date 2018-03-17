package demo13;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.aop.ThrowsAdvice;

/**
 * Created by mycom on 2018/3/8.
 */
public class MyThroesAdvice implements ThrowsAdvice {
    public void afterThrowing(Exception ex){
        System.out.println("网络出现错误");
    }
}
