package com.github.vvzhuchkov.task03.entity;

public class Oven extends Appliance {
    private final int powerConsumption;
    private final double weight;
    private final int capacity;
    private final double depth;
    private final double height;
    private final double width;

    public Oven(OvenBuilder ovenBuilder) {
        this.powerConsumption = ovenBuilder.getPowerConsumption();
        this.weight = ovenBuilder.getWeight();
        this.capacity = ovenBuilder.getCapacity();
        this.depth = ovenBuilder.getDepth();
        this.height = ovenBuilder.getHeight();
        this.width = ovenBuilder.getWidth();
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
}




