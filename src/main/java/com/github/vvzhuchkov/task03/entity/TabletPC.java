package com.github.vvzhuchkov.task03.entity;

import java.util.Objects;

public class TabletPC extends Appliance {
    private final int batteryCapacity;
    private final double displayInches;
    private final int memoryRom;
    private final int flashMemoryCapacity;
    private final String color;

    private TabletPC(TabletPCBuilder tabletPCBuilder) {
        super(tabletPCBuilder.getBrand(), tabletPCBuilder.getModel(), tabletPCBuilder.getPrice());
        this.batteryCapacity = tabletPCBuilder.getBatteryCapacity();
        this.displayInches = tabletPCBuilder.getDisplayInches();
        this.memoryRom = tabletPCBuilder.getMemoryRom();
        this.flashMemoryCapacity = tabletPCBuilder.getFlashMemoryCapacity();
        this.color = tabletPCBuilder.getColor();
    }

    public static class TabletPCBuilder {
        private final String brand;
        private final String model;
        private final double price;
        private int batteryCapacity = 0;
        private double displayInches = 0;
        private int memoryRom = 0;
        private int flashMemoryCapacity = 0;
        private String color = null;


        public TabletPCBuilder(String brand, String model, double price) {
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

        public int getBatteryCapacity() {
            return batteryCapacity;
        }

        public TabletPCBuilder setBatteryCapacity(int batteryCapacity) {
            this.batteryCapacity = batteryCapacity;
            return this;
        }

        public double getDisplayInches() {
            return displayInches;
        }

        public TabletPCBuilder setDisplayInches(double displayInches) {
            this.displayInches = displayInches;
            return this;
        }

        public int getMemoryRom() {
            return memoryRom;
        }

        public TabletPCBuilder setMemoryRom(int memoryRom) {
            this.memoryRom = memoryRom;
            return this;
        }

        public int getFlashMemoryCapacity() {
            return flashMemoryCapacity;
        }

        public TabletPCBuilder setFlashMemoryCapacity(int flashMemoryCapacity) {
            this.flashMemoryCapacity = flashMemoryCapacity;
            return this;
        }

        public String getColor() {
            return color;
        }

        public TabletPCBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public TabletPC build() {
            return new TabletPC(this);
        }
    }

    @Override
    public String toString() {
        return "TabletPC{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", batteryCapacity=" + batteryCapacity +
                ", displayInches=" + displayInches +
                ", memoryRom=" + memoryRom +
                ", flashMemoryCapacity=" + flashMemoryCapacity +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TabletPC tabletPC = (TabletPC) o;
        return batteryCapacity == tabletPC.batteryCapacity && Double.compare(tabletPC.displayInches, displayInches) == 0
                && memoryRom == tabletPC.memoryRom && flashMemoryCapacity == tabletPC.flashMemoryCapacity
                && color.equals(tabletPC.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(batteryCapacity, displayInches, memoryRom, flashMemoryCapacity, color);
    }
}
