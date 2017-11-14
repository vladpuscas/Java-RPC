package entities;

import java.io.Serializable;

/**
 * Created by Vlad on 13-Nov-17.
 */
public class Car implements Serializable {
    private int year;
    private int engineSize;
    private double price;

    public Car() {
    }

    public Car(int year, int engineSize, double price) {
        this.year = year;
        this.engineSize = engineSize;
        this.price = price;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getEngineSize() {
        return engineSize;
    }

    public void setEngineSize(int engineSize) {
        this.engineSize = engineSize;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
