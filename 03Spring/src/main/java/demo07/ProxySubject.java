package demo07;

/**
 * Created by mycom on 2018/3/6.
 */
public class ProxySubject implements Subject {
    private RealSubject realSubject;

    public RealSubject getRealSubject() {
        return realSubject;
    }

    public void setRealSubject(RealSubject realSubject) {
        this.realSubject = realSubject;
    }

    public void request() {
        System.out.println("Before====");
        realSubject.request();
        System.out.println("After====");
    }
}
