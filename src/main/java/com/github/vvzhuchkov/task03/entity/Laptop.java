package com.github.vvzhuchkov.task03.entity;

import java.util.Objects;

public class Laptop extends Appliance {
    private final int batteryCapacity;
    private final String operationSystem;
    private final int memoryRom;
    private final int systemMemory;
    private final double cpu;
    private final int displayInches;

    private Laptop(LaptopBuilder laptopBuilder) {
        super(laptopBuilder.getBrand(), laptopBuilder.getModel(), laptopBuilder.getPrice());
        this.batteryCapacity = laptopBuilder.getBatteryCapacity();
        this.operationSystem = laptopBuilder.getOperationSystem();
        this.memoryRom = laptopBuilder.getMemoryRom();
        this.systemMemory = laptopBuilder.getSystemMemory();
        this.cpu = laptopBuilder.getCpu();
        this.displayInches = laptopBuilder.getDisplayInches();
    }

    public static class LaptopBuilder {
        private final String brand;
        private final String model;
        private final double price;
        private int batteryCapacity = 0;
        private String operationSystem = null;
        private int memoryRom = 0;
        private int systemMemory = 0;
        private double cpu = 0;
        private int displayInches = 0;

        public LaptopBuilder(String brand, String model, double price) {
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

        public LaptopBuilder setBatteryCapacity(int batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
            return this;
        }

        public LaptopBuilder setOperationSystem(String operationSystem) {
            this.operationSystem = operationSystem;
            return this;
        }

        public LaptopBuilder setMemoryRom(int memoryRom) {
            this.memoryRom = memoryRom;
            return this;
        }

        public LaptopBuilder setSystemMemory(int systemMemory) {
            this.systemMemory = systemMemory;
            return this;
        }

        public LaptopBuilder setCpu(double cpu) {
            this.cpu = cpu;
            return this;
        }

        public LaptopBuilder setDisplayInches(int displayInches) {
            this.displayInches = displayInches;
            return this;
        }

        public int getBatteryCapacity() {
            return batteryCapacity;
        }

        public String getOperationSystem() {
            return operationSystem;
        }

        public int getMemoryRom() {
            return memoryRom;
        }

        public int getSystemMemory() {
            return systemMemory;
        }

        public double getCpu() {
            return cpu;
        }

        public int getDisplayInches() {
            return displayInches;
        }

        public Laptop build() {
            return new Laptop(this);
        }
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", batteryCapacity=" + batteryCapacity +
                ", operationSystem='" + operationSystem + '\'' +
                ", memoryRom=" + memoryRom +
                ", systemMemory=" + systemMemory +
                ", cpu=" + cpu +
                ", displayInches=" + displayInches +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return batteryCapacity == laptop.batteryCapacity && memoryRom == laptop.memoryRom
                && systemMemory == laptop.systemMemory && Double.compare(laptop.cpu, cpu) == 0
                && displayInches == laptop.displayInches && operationSystem.equals(laptop.operationSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, operationSystem, memoryRom, systemMemory, cpu, displayInches);
    }
}
