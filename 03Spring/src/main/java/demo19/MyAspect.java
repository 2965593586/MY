package demo19;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

/**
 * Created by mycom on 2018/3/12.
 */
@Aspect
public class MyAspect {
    @Pointcut(value = "execution(* demo19.*.update(..))")
    public void update(){

    }

    @Pointcut(value = "execution(* demo19.*.insert(..))")
    public void insert(){

    }


    @Before("execution(* demo19.*.insert(..))")
    public void myBefore(){
        System.out.println("before===");
    }

    /*@AfterReturning("execution(* demo19.*.select(..))")
    public void myAfter(){
        System.out.println("after===");
    }*/
    //环绕增强
    @Around("update()||insert()")
    public void myAround(ProceedingJoinPoint joinPoint) throws Throwable {
        System.out.println("before=====");
        joinPoint.proceed();
        System.out.println("after===");
    }

    @AfterThrowing(value = "execution(* demo19.*.select(..))",throwing = "error")
    public void myThrows(Exception error){
        System.out.println("出现异常了"+error);
    }

    @After("execution(* demo19.*.select(..))")
    public void myFinally(){
        System.out.println("最终增强");
    }
}
