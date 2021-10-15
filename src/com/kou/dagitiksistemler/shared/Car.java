package com.kou.dagitiksistemler.shared;

import java.io.Serializable;

public class Car implements Serializable {
    public Integer serialNumber;
    public String brand;
    public String model;
    public String color;
    public Integer year;
    public Integer weight;
    public Integer price;

    public Car(Integer serialNumber, String brand, String model, String color, Integer year, Integer weight, Integer price) {
        this.serialNumber = serialNumber;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.year = year;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "serialNumber=" + serialNumber +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", year=" + year +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
