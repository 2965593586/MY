package demoTransaction.entity;

/**
 * Created by mycom on 2018/3/16.
 */
public class Account {
    private Integer aid;
    private String aname;
    private Integer abalance;

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public Integer getAbalance() {
        return abalance;
    }

    public void setAbalance(Integer abalance) {
        this.abalance = abalance;
    }
}
