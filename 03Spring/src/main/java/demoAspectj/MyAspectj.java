package demoAspectj;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Pointcut;

/**
 * Created by mycom on 2018/3/12.
 */
public class MyAspectj {
    // 前置通知
    public void before(){
        System.out.println("前置通知方法before()");
    }
    public void before(JoinPoint jp){
        System.out.println("前置通知方法before（）jp="+jp);
    }

    // 后置通知
    public void afterReturing(){
        System.out.println("后置通知方法");
    }
    public void afterReturing(String result){
        System.out.println("后置通知方法 result = " + result);
    }


    // 环绕通知
    public void around(ProceedingJoinPoint pjp) throws Throwable{
        System.out.println("环绕通知方法，目标方法执行之前");
        // 执行目标方法
        Object result = pjp.proceed();
        System.out.println("环绕通知方法，目标方法执行之后");
    }

    // 异常通知
    public void afterThrowing(){
        System.out.println("异常通知方法");
    }


    // 最终通知
    public void after(){
        System.out.println("最终通知方法");
    }
}
