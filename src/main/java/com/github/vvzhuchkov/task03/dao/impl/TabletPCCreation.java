package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.TabletPC;

import java.util.List;

public class TabletPCCreation {
    public Appliance applianceCreation(List<String> parametersAppliance) {
        return new TabletPC.TabletPCBuilder(parametersAppliance.get(1), parametersAppliance.get(2), Double.parseDouble(parametersAppliance.get(3)))
                .setBatteryCapacity(Integer.parseInt(parametersAppliance.get(4)))
                .setDisplayInches(Double.parseDouble(parametersAppliance.get(5)))
                .setMemoryRom(Integer.parseInt(parametersAppliance.get(6)))
                .setFlashMemoryCapacity(Integer.parseInt(parametersAppliance.get(7)))
                .setColor(parametersAppliance.get(8))
                .build();
    }
}
