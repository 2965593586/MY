package demo03.printer;

import demo03.ink.Ink;
import demo03.paper.Paper;

/**
 * Created by mycom on 2018/3/3.
 */
public class Printer {
    private Ink ink;
    private Paper paper;

    public Ink getInk() {
        return ink;
    }

    public void setInk(Ink ink) {
        this.ink = ink;
    }

    public void printer(){
        System.out.println("我在一张"+ink.getInk()+"颜色的"+paper.getPaper()+"纸上写东西了");
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }
}
