package com.github.vvzhuchkov.task03.entity;

import java.util.Objects;

public class Oven extends Appliance {
    private final int powerConsumption;
    private final double weight;
    private final int capacity;
    private final double depth;
    private final double height;
    private final double width;

    private Oven(OvenBuilder ovenBuilder) {
        super(ovenBuilder.getBrand(), ovenBuilder.getModel(), ovenBuilder.getPrice());
        this.powerConsumption = ovenBuilder.getPowerConsumption();
        this.weight = ovenBuilder.getWeight();
        this.capacity = ovenBuilder.getCapacity();
        this.depth = ovenBuilder.getDepth();
        this.height = ovenBuilder.getHeight();
        this.width = ovenBuilder.getWidth();
    }

    public static class OvenBuilder {
        private final String brand;
        private final String model;
        private final double price;
        private int powerConsumption = 0;
        private double weight = 0;
        private int capacity = 0;
        private double depth = 0;
        private double height = 0;
        private double width = 0;

        public OvenBuilder(String brand, String model, double price) {
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

        public OvenBuilder setPowerConsumption(int powerConsumption) {
            this.powerConsumption = powerConsumption;
            return this;
        }

        public OvenBuilder setWeight(double weight) {
            this.weight = weight;
            return this;
        }

        public OvenBuilder setCapacity(int capacity) {
            this.capacity = capacity;
            return this;
        }

        public OvenBuilder setDepth(double depth) {
            this.depth = depth;
            return this;
        }

        public OvenBuilder setHeight(double height) {
            this.height = height;
            return this;
        }

        public OvenBuilder setWidth(double width) {
            this.width = width;
            return this;
        }

        public int getPowerConsumption() {
            return powerConsumption;
        }

        public double getWeight() {
            return weight;
        }

        public int getCapacity() {
            return capacity;
        }

        public double getDepth() {
            return depth;
        }

        public double getHeight() {
            return height;
        }

        public double getWidth() {
            return width;
        }

        public Oven build() {
            return new Oven(this);
        }
    }

    @Override
    public String toString() {
        return "Oven {" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", powerConsumption=" + powerConsumption +
                ", weight=" + weight +
                ", capacity=" + capacity +
                ", depth=" + depth +
                ", height=" + height +
                ", width=" + width +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Oven oven = (Oven) o;
        return powerConsumption == oven.powerConsumption && Double.compare(oven.weight, weight) == 0
                && capacity == oven.capacity && Double.compare(oven.depth, depth) == 0
                && Double.compare(oven.height, height) == 0 && Double.compare(oven.width, width) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, weight, capacity, depth, height, width);
    }
}




