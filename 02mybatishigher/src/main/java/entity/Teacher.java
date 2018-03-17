package entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mycom on 2018/2/26.
 */
public class Teacher {
    private Integer tid;
    private String tname;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<Student> getStus() {
        return stus;
    }

    public void setStus(List<Student> stus) {
        this.stus = stus;
    }

    //植入学生集合
    private List<Student> stus=new ArrayList<Student>();

}
