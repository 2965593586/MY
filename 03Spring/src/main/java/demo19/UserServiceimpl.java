package demo19;

/**
 * Created by mycom on 2018/3/12.
 */
public class UserServiceimpl implements IUserService {
    public void select() {
        try{
            int i=2/0;
        }catch(Exception ex){
            ex.printStackTrace();
        }

        System.out.println("select  ok!");
    }

    public void update() {
        System.out.println("update  ok!");
    }

    public void insert() {
        System.out.println("insert  ok!");
    }

    public void delect() {
        System.out.println("delect  ok!");
    }
}
