package demo09;


import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by mycom on 2018/3/8.
 */
public class Test {
    public static void main(String[] args) {
        final SomeServiceImpl service=new SomeServiceImpl();
        Enhancer enhancer=new Enhancer();
        enhancer.setSuperclass(service.getClass());
        enhancer.setCallback(new MethodInterceptor() {
            /**
             *
             * @param o 代理对象
             * @param method 目标类型的方法
             * @param objects 目标方法的参数
             * @param methodProxy 代理类的方法   是一个新的参数
             * @return
             * @throws Throwable
             */
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("before=====");
                methodProxy.invoke(service,objects);
                System.out.println("after=====");
                return null;
            }
        });
        SomeServiceImpl proxy =(SomeServiceImpl) enhancer.create();
        proxy.doSome();
    }
}
