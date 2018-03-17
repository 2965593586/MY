package demo15;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by mycom on 2018/3/8.
 */
public class Test {
    public static void main(String[] args) {
        //首先创建一个接口的实现类
        final SomeServiceImpl service=new SomeServiceImpl();
        //在调用方法之前想使用动态代理记录一下日志，生成动态代理,返回的是接口
        ISomeService proxyInstance =(ISomeService) Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(), new InvocationHandler() {
                    /**
                     *
                     * @param proxy  代理对象
                     * @param method  目标类型的方法
                     * @param args  方法的参数
                     * @return
                     * @throws Throwable
                     */
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //在这里记录一下日志
                        System.out.println("before=====");
                        //调用method 的
                        method.invoke(service,args);//相当于执行目标类型的方法
                        System.out.println("after=======");
                        return null;
                    }
                });

        //调用动态代理中的方法中的方法
        proxyInstance.doSome();
    }
}
