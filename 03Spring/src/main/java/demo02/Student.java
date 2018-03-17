package demo02;

/**
 * Created by mycom on 2018/3/3.
 */
public class Student {
    private String name;
    private Integer age;
    private Car car;



    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
