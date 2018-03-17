package entity;

import java.util.List;

/**
 * Created by mycom on 2018/2/26.
 */
public class Category {
    private Integer cid;
    private String cname;
    private List<Category> cates;

    @Override
    public String toString() {
        return "Category{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", cates=" + cates +
                '}';
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public List<Category> getCates() {
        return cates;
    }

    public void setCates(List<Category> cates) {
        this.cates = cates;
    }
}
