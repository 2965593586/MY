package demo01;

/**
 * Created by mycom on 2018/3/11.
 */
public class Person {
    private String name;
    private String words;

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void say(){
        System.out.println(getName()+"说："+"“"+getWords()+"”");
    }
}
