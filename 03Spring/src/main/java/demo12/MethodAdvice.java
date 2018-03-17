package demo12;


import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * Created by mycom on 2018/3/8.
 */
public class MethodAdvice implements MethodInterceptor {


    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("前置增强");
        Object result = methodInvocation.proceed();
        System.out.println("后置增强");
        return result;
    }
}
