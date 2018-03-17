package demo01;

/**
 * Created by mycom on 2018/3/6.
 */
public class MySingleton {
    //内部类
    private static class MySingletonHandler{
        private static MySingleton instance = new MySingleton();
    }

    private MySingleton(){}

    public static MySingleton getInstance() {
        return MySingletonHandler.instance;
    }
}
