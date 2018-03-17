package demo02.printer;

import demo02.mohe.Mohe;
import demo02.paper.Paper;

/**
 * Created by mycom on 2018/3/11.
 */
public class Printer {
    //声明一个墨盒，纸张
    private Mohe mohe;
    private Paper paper;

    public Mohe getMohe() {
        return mohe;
    }

    public void setMohe(Mohe mohe) {
        this.mohe = mohe;
    }

    public Paper getPaper() {
        return paper;
    }

    public void setPaper(Paper paper) {
        this.paper = paper;
    }

    @Override
    public String toString() {
        return "Printer{" +
                "mohe=" + mohe +
                ", paper=" + paper +
                '}';
    }

    public void printer(){
        System.out.println("这是用"+mohe.moke()+"在一张"+paper.paper()+"上打印东西");
    }
}
