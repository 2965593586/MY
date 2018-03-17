package entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by mycom on 2018/3/1.
 */
public class Talk {
    private Integer tid;
    private String content;
    private Date talkTime;
    private Integer nid;
    private String tTime;

    public String gettTime() {
        SimpleDateFormat format=new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String tTime = format.format(talkTime);
        return tTime;
    }

    public void settTime(String tTime) {
        this.tTime = tTime;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(Date talkTime) {
        this.talkTime = talkTime;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }
}
