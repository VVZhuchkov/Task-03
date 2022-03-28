package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.Laptop;

import java.util.List;

public class LaptopCreation {

    public Appliance applianceCreation(List<String> parametersAppliance) {
        return new Laptop.LaptopBuilder(parametersAppliance.get(1), parametersAppliance.get(2), Double.parseDouble(parametersAppliance.get(3)))
                .setBatteryCapacity(Integer.parseInt(parametersAppliance.get(4)))
                .setOperationSystem(parametersAppliance.get(5))
                .setMemoryRom(Integer.parseInt(parametersAppliance.get(6)))
                .setSystemMemory(Integer.parseInt(parametersAppliance.get(7)))
                .setCpu(Double.parseDouble(parametersAppliance.get(8)))
                .setDisplayInches(Integer.parseInt(parametersAppliance.get(9)))
                .build();
    }
}
