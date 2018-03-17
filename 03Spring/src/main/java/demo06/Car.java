package demo06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Created by mycom on 2018/3/5.
 */
@Component("car")
public class Car {
    @Value("红色")
    private String color;
    private String brand;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {

        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
