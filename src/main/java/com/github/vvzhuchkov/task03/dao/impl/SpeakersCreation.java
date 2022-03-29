package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.dao.ApplianceCreation;
import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.Speakers;

import java.util.List;

public class SpeakersCreation implements ApplianceCreation {
    public Appliance applianceCreation(List<String> parametersAppliance) {
        return new Speakers.SpeakersBuilder(parametersAppliance.get(1), parametersAppliance.get(2), Double.parseDouble(parametersAppliance.get(3)))
                .setPowerConsumption(Integer.parseInt(parametersAppliance.get(4)))
                .setNumberOfSpeakers(Integer.parseInt(parametersAppliance.get(5)))
                .setFrequencyRange(parametersAppliance.get(6))
                .setCordLength(Double.parseDouble(parametersAppliance.get(7)))
                .build();
    }
}
