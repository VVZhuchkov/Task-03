package com.github.vvzhuchkov.task03.entity;

import java.util.Objects;

public class VacuumCleaner extends Appliance {
    private final int powerConsumption;
    private final String filterType;
    private final String bagType;
    private final String wandType;
    private final int motorSpeedRegulation;
    private final int cleaningWidth;

    private VacuumCleaner(VacuumCleanerBuilder vacuumCleanerBuilder) {
        super(vacuumCleanerBuilder.getBrand(), vacuumCleanerBuilder.getModel(), vacuumCleanerBuilder.getPrice());
        this.powerConsumption = vacuumCleanerBuilder.getPowerConsumption();
        this.filterType = vacuumCleanerBuilder.getFilterType();
        this.bagType = vacuumCleanerBuilder.getBagType();
        this.wandType = vacuumCleanerBuilder.getWandType();
        this.motorSpeedRegulation = vacuumCleanerBuilder.getMotorSpeedRegulation();
        this.cleaningWidth = vacuumCleanerBuilder.getCleaningWidth();
    }

   public static class VacuumCleanerBuilder{
       private final String brand;
       private final String model;
       private final double price;
       private int powerConsumption = 0;
       private String filterType = null;
       private String bagType = null;
       private String wandType = null;
       private int motorSpeedRegulation = 0;
       private int cleaningWidth = 0;

       public VacuumCleanerBuilder(String brand, String model, double price) {
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

       public VacuumCleanerBuilder setPowerConsumption(int powerConsumption) {
           this.powerConsumption = powerConsumption;
           return this;
       }

       public String getFilterType() {
           return filterType;
       }

       public VacuumCleanerBuilder setFilterType(String filterType) {
           this.filterType = filterType;
           return this;
       }

       public String getBagType() {
           return bagType;
       }

       public VacuumCleanerBuilder setBagType(String bagType) {
           this.bagType = bagType;
           return this;
       }

       public String getWandType() {
           return wandType;
       }

       public VacuumCleanerBuilder setWandType(String wandType) {
           this.wandType = wandType;
           return this;
       }

       public int getMotorSpeedRegulation() {
           return motorSpeedRegulation;
       }

       public VacuumCleanerBuilder setMotorSpeedRegulation(int motorSpeedRegulation) {
           this.motorSpeedRegulation = motorSpeedRegulation;
           return this;
       }

       public int getCleaningWidth() {
           return cleaningWidth;
       }

       public VacuumCleanerBuilder setCleaningWidth(int cleaningWidth) {
           this.cleaningWidth = cleaningWidth;
           return this;
       }

       public VacuumCleaner build(){
           return new VacuumCleaner(this);
       }
   }

    @Override
    public String toString() {
        return "VacuumCleaner{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price +
                ", powerConsumption=" + powerConsumption +
                ", filterType='" + filterType + '\'' +
                ", bagType='" + bagType + '\'' +
                ", wandType='" + wandType + '\'' +
                ", motorSpeedRegulation=" + motorSpeedRegulation +
                ", cleaningWidth=" + cleaningWidth +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        VacuumCleaner that = (VacuumCleaner) o;
        return powerConsumption == that.powerConsumption && motorSpeedRegulation == that.motorSpeedRegulation
                && cleaningWidth == that.cleaningWidth && Objects.equals(filterType, that.filterType)
                && Objects.equals(bagType, that.bagType) && Objects.equals(wandType, that.wandType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(powerConsumption, filterType, bagType, wandType, motorSpeedRegulation, cleaningWidth);
    }
}
