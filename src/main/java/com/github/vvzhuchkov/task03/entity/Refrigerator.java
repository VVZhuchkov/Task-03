package com.github.vvzhuchkov.task03.entity;

import java.util.Objects;

public class Refrigerator extends Appliance {
    private final int powerConsumption;
    private final double weight;
    private final int freezerCapacity;
    private final int overallCapacity;
    private final double height;
    private final double width;

    private Refrigerator(RefrigeratorBuilder refrigeratorBuilder) {
        super(refrigeratorBuilder.getBrand(), refrigeratorBuilder.getModel(), refrigeratorBuilder.getPrice());
        this.powerConsumption = refrigeratorBuilder.getPowerConsumption();
        this.weight = refrigeratorBuilder.getWeight();
        this.freezerCapacity = refrigeratorBuilder.getFreezerCapacity();
        this.overallCapacity = refrigeratorBuilder.getOverallCapacity();
        this.height = refrigeratorBuilder.getHeight();
        this.width = refrigeratorBuilder.getWidth();
    }

    public static class RefrigeratorBuilder {
        private final String brand;
        private final String model;
        private final double price;
        private int powerConsumption = 0;
        private double weight = 0;
        private int freezerCapacity = 0;
        private int overallCapacity = 0;
        private double height = 0;
        private double width = 0;

        public RefrigeratorBuilder(String brand, String model, double price) {
            this.brand = brand;
            this.model = model;
            this.price = price;
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public double getPrice() {
            return price;
        }

        public int getPowerConsumption() {
            return powerConsumption;
        }

        public RefrigeratorBuilder setPowerConsumption(int powerConsumption) {
            this.powerConsumption = powerConsumption;
            return this;
        }

        public double getWeight() {
            return weight;
        }

        public RefrigeratorBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public int getFreezerCapacity() {
            return freezerCapacity;
        }

        public RefrigeratorBuilder setFreezerCapacity(int freezerCapacity) {
            this.freezerCapacity = freezerCapacity;
            return this;
        }

        public int getOverallCapacity() {
            return overallCapacity;
        }

        public RefrigeratorBuilder setOverallCapacity(int overallCapacity) {
            this.overallCapacity = overallCapacity;
            return this;
        }

        public double getHeight() {
            return height;
        }

        public RefrigeratorBuilder setHeight(double height) {
            this.height = height;
            return this;
        }

        public double getWidth() {
            return width;
        }

        public RefrigeratorBuilder setWidth(double width) {
            this.width = width;
            return this;
        }

        public Refrigerator build() {
            return new Refrigerator(this);

        }
    }

    @Override
    public String toString() {
        return "Refrigerator {" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", freezerCapacity=" + freezerCapacity +
                ", overallCapacity=" + overallCapacity +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Refrigerator that = (Refrigerator) o;
        return powerConsumption == that.powerConsumption && Double.compare(that.weight, weight) == 0
                && freezerCapacity == that.freezerCapacity && overallCapacity == that.overallCapacity
                && Double.compare(that.height, height) == 0 && Double.compare(that.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, freezerCapacity, overallCapacity, height, width);
    }
}