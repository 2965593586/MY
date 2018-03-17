package demo06;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * Created by mycom on 2018/3/5.
 */
@Component("student")
public class Student {
    @Value("张三")
    private String name;
    private Integer age;
    //@Resource(name="car")  //Resource是JDK提供的注解  import javax.annotation.Resource;
    @Autowired
    @Qualifier(value = "car") //Spring提供的注解import org.springframework.beans.factory.annotation.Autowired;
                              //import org.springframework.beans.factory.annotation.Qualifier;
    private Car car;

    public Student() {
    }

    public Student(String name, Integer age) {

        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }
}
