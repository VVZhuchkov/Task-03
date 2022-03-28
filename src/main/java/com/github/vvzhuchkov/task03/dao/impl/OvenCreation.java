package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.Oven;

import java.util.List;

public class OvenCreation {

    public Appliance applianceCreation(List<String> parametersAppliance) {
        return new Oven.OvenBuilder(parametersAppliance.get(1), parametersAppliance.get(2), Double.parseDouble(parametersAppliance.get(3)))
                .setPowerConsumption(Integer.parseInt(parametersAppliance.get(4)))
                .setWeight(Double.parseDouble(parametersAppliance.get(5)))
                .setCapacity(Integer.parseInt(parametersAppliance.get(6)))
                .setDepth(Double.parseDouble(parametersAppliance.get(7)))
                .setHeight(Double.parseDouble(parametersAppliance.get(8)))
                .setWidth(Double.parseDouble(parametersAppliance.get(9)))
                .build();
    }
}
