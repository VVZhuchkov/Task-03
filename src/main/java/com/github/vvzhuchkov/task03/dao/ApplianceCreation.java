package com.github.vvzhuchkov.task03.dao;

import com.github.vvzhuchkov.task03.entity.Appliance;

import java.util.List;

public interface ApplianceCreation {
    Appliance applianceCreation(List<String> parametersAppliance);
}
