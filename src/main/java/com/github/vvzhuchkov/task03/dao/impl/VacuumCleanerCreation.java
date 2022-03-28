package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.VacuumCleaner;

import java.util.List;

public class VacuumCleanerCreation {
    public Appliance applianceCreation(List<String> parametersAppliance) {
        return new VacuumCleaner.VacuumCleanerBuilder(parametersAppliance.get(1), parametersAppliance.get(2), Double.parseDouble(parametersAppliance.get(3)))
                .setPowerConsumption(Integer.parseInt(parametersAppliance.get(4)))
                .setFilterType(parametersAppliance.get(5))
                .setBagType(parametersAppliance.get(6))
                .setWandType(parametersAppliance.get(7))
                .setMotorSpeedRegulation(Integer.parseInt(parametersAppliance.get(8)))
                .setCleaningWidth(Integer.parseInt(parametersAppliance.get(9)))
                .build();
    }
}
