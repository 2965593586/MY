package demo22tx.entity;

/**
 * Created by mycom on 2018/3/15.
 */
public class Account {
    private Integer aid;
    private String aname;

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

    public Integer getAblance() {
        return ablance;
    }

    public void setAblance(Integer ablance) {
        this.ablance = ablance;
    }

    private Integer ablance;
}
