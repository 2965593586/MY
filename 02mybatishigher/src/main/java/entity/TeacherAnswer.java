package entity;

/**
 * Created by mycom on 2018/2/1.
 */
public class TeacherAnswer {
    private Integer id;
    private String className;
    private Integer tid;
    private String tresult;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTresult() {
        return tresult;
    }

    public void setTresult(String tresult) {
        this.tresult = tresult;
    }
}
