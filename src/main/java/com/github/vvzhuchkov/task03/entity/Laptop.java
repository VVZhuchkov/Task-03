package com.github.vvzhuchkov.task03.entity;

public class Laptop implements Appliance {
    private String batteryCapacity;
    private String operationSystem;
    private String memoryRom;
    private String systemMemory;
    private String cpu;
    private String displayInches;

    public Laptop(String batteryCapacity, String operationSystem, String memoryRom, String systemMemory, String cpu,
                  String displayInches) {
        this.batteryCapacity = batteryCapacity;
        this.operationSystem = operationSystem;
        this.memoryRom = memoryRom;
        this.systemMemory = systemMemory;
        this.cpu = cpu;
        this.displayInches = displayInches;
    }

    public String getBatteryCapacity() {
        return batteryCapacity;
    }

    public void setBatteryCapacity(String batteryCapacity) {
        this.batteryCapacity = batteryCapacity;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getMemoryRom() {
        return memoryRom;
    }

    public void setMemoryRom(String memoryRom) {
        this.memoryRom = memoryRom;
    }

    public String getSystemMemory() {
        return systemMemory;
    }

    public void setSystemMemory(String systemMemory) {
        this.systemMemory = systemMemory;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getDisplayInches() {
        return displayInches;
    }

    public void setDisplayInches(String displayInches) {
        this.displayInches = displayInches;
    }
}
