package com.github.vvzhuchkov.task03.entity;

public abstract class Appliance {
    String brand;
    String model;
    double price;

    Appliance(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }
}
