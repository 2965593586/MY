package demo03;

/**
 * Created by mycom on 2018/3/13.
 */
public class SomeServiceImpl implements ISomeService {
    public void select() {
        System.out.println("select ok");
    }

    public void insert() {
        System.out.println("insert ok");
    }

    public void delete() {
        System.out.println("delete ok");
    }

    public void update() {
        System.out.println("update ok");
    }
}
