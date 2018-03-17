package demo08;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by mycom on 2018/3/8.
 */
public class Test {
    public static void main(String[] args) {
        //创建对象
        final SomeServiceImpl service=new SomeServiceImpl();
        //这里的返回的类型必须是接口
        ISomeService proxy =(ISomeService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(), new InvocationHandler() {
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("前置增强");
                        method.invoke(service,args);
                        return null;
                    }
                });
        proxy.doSome();
    }
}
