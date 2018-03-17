package demo01;

import java.util.StringTokenizer;

/**
 * Created by mycom on 2018/3/3.
 */
public class HappyService {
    private String info;
    private Integer age;

    public HappyService(){
        System.out.println("======HappyService");
    }

    public void work(){
        System.out.println("我是"+info);
    }

    public String getInfo() {
        return info;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
