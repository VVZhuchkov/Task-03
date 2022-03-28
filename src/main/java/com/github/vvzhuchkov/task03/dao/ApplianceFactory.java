package com.github.vvzhuchkov.task03.dao;

import com.github.vvzhuchkov.task03.dao.impl.*;
import com.github.vvzhuchkov.task03.entity.Appliance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplianceFactory {
    static Map<String, Appliance> applianceMap = new HashMap<>();

    public static Appliance applianceFactory(List <String> parametersAppliance) {
        applianceMap.put("Oven", new OvenCreation().applianceCreation(parametersAppliance));
        applianceMap.put("Laptop", new LaptopCreation().applianceCreation(parametersAppliance));
        applianceMap.put("Refrigerator", new RefrigeratorCreation().applianceCreation(parametersAppliance));
        applianceMap.put("Speakers", new SpeakersCreation().applianceCreation(parametersAppliance));
        applianceMap.put("TabletPC", new TabletPCCreation().applianceCreation(parametersAppliance));
        applianceMap.put("VacuumCleaner", new VacuumCleanerCreation().applianceCreation(parametersAppliance));
        return applianceMap.get(parametersAppliance.get(0));
    }
}
