package demoTransaction.entity;

/**
 * Created by mycom on 2018/3/16.
 */
public class Stock {
    private Integer sid;
    private String sname;
    private Integer count;

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
