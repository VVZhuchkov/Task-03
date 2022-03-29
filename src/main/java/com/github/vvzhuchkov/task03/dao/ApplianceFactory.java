package com.github.vvzhuchkov.task03.dao;

import com.github.vvzhuchkov.task03.dao.impl.*;
import com.github.vvzhuchkov.task03.entity.Appliance;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ApplianceFactory {
    static Map<String, ApplianceCreation> applianceMap = new HashMap<>();

    public static Appliance applianceFactory(List<String> parametersAppliance) {
        applianceMap.put("Oven", new OvenCreation());
        applianceMap.put("Laptop", new LaptopCreation());
        applianceMap.put("Refrigerator", new RefrigeratorCreation());
        applianceMap.put("Speakers", new SpeakersCreation());
        applianceMap.put("TabletPC", new TabletPCCreation());
        applianceMap.put("VacuumCleaner", new VacuumCleanerCreation());
        ApplianceCreation applianceCreation = applianceMap.get(parametersAppliance.get(0));
        return applianceCreation.applianceCreation(parametersAppliance);
    }
}
