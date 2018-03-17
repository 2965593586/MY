package demoAspectj;

/**
 * Created by mycom on 2018/3/12.
 */
public class UserServiceImpl implements IUserService {
    public void select() {
        System.out.println("select");
    }

    public void update() {
        System.out.println("update");
    }

    public void insert() {
        System.out.println("insert");
    }

    public void delect() {
        System.out.println("delect");
    }
}
