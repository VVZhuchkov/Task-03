package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.dao.ApplianceDAO;
import com.github.vvzhuchkov.task03.entity.*;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ApplianceDAOImpl implements ApplianceDAO {
    private final InputStream inputStream = databasePath();

    @Override
    public InputStream databasePath() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("appliances_db.txt");
        return inputStream;
    }

    @Override
    public List<String> readingParameters(String typeAppliance, String parametersAppliance) {
        List<String> parameters = new ArrayList<>();
        parameters.add(typeAppliance);
        Pattern pattern = Pattern.compile("=[^, ]+|\\S+]");
        Matcher matcher = pattern.matcher(parametersAppliance);
        while (matcher.find()) {
            parameters.add(parametersAppliance.substring(matcher.start() + 1, matcher.end()));
        }
        return parameters;
    }

    @Override
    public List<Appliance> find(Criteria criteria) {
        List<Appliance> appliances = new ArrayList<>();
        int coincidence = 0;
        String appliance;
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(databasePath()))) {
            while ((appliance = bufferedReader.readLine()) != null) {
                if (!appliance.isEmpty()) {
                    String[] typeAppliance = appliance.split(" : ");
                    String[] parameters = typeAppliance[1].split(", ");
                    if (typeAppliance[0].equals(criteria.getGroupSearchName())) {
                        for (Map.Entry<String, Object> oneCrit : criteria.getCriteria().entrySet()) {
                            String searchParameter = oneCrit.getKey() + "=" + oneCrit.getValue();
                            for (String parameter : parameters) {
                                if (parameter.equals(searchParameter)) {
                                    coincidence++;
                                    if (coincidence == criteria.getCriteria().size()) {
                                        appliances.add(createAppliance(readingParameters(typeAppliance[0], typeAppliance[1])));
                                    }
                                }
                            }
                        }
                        coincidence = 0;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Database connection error");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appliances;
    }

    public Appliance createAppliance(List<String> parameters) {
        switch (parameters.get(0)) {
            case "Oven":
                return new Oven.OvenBuilder(parameters.get(1), parameters.get(2), Double.parseDouble(parameters.get(3)))
                        .setPowerConsumption(Integer.parseInt(parameters.get(4)))
                        .setWeight(Double.parseDouble(parameters.get(5)))
                        .setCapacity(Integer.parseInt(parameters.get(6)))
                        .setDepth(Double.parseDouble(parameters.get(7)))
                        .setHeight(Double.parseDouble(parameters.get(8)))
                        .setWidth(Double.parseDouble(parameters.get(9)))
                        .build();
            case "Laptop":
                return new Laptop.LaptopBuilder(parameters.get(1), parameters.get(2), Double.parseDouble(parameters.get(3)))
                        .setBatteryCapacity(Integer.parseInt(parameters.get(4)))
                        .setOperationSystem(parameters.get(5))
                        .setMemoryRom(Integer.parseInt(parameters.get(6)))
                        .setSystemMemory(Integer.parseInt(parameters.get(7)))
                        .setCpu(Double.parseDouble(parameters.get(8)))
                        .setDisplayInches(Integer.parseInt(parameters.get(9)))
                        .build();
            case "Refrigerator":
                return new Refrigerator.RefrigeratorBuilder(parameters.get(1), parameters.get(2), Double.parseDouble(parameters.get(3)))
                        .setPowerConsumption(Integer.parseInt(parameters.get(4)))
                        .setWeight(Double.parseDouble(parameters.get(5)))
                        .setFreezerCapacity(Integer.parseInt(parameters.get(6)))
                        .setOverallCapacity(Integer.parseInt(parameters.get(7)))
                        .setHeight(Double.parseDouble(parameters.get(8)))
                        .setWidth(Double.parseDouble(parameters.get(9)))
                        .build();
            case "Speakers":
                return new Speakers.SpeakersBuilder(parameters.get(1), parameters.get(2), Double.parseDouble(parameters.get(3)))
                        .setPowerConsumption(Integer.parseInt(parameters.get(4)))
                        .setNumberOfSpeakers(Integer.parseInt(parameters.get(5)))
                        .setFrequencyRange(parameters.get(6))
                        .setCordLength(Double.parseDouble(parameters.get(7)))
                        .build();
            case "TabletPC":
                return new TabletPC.TabletPCBuilder(parameters.get(1), parameters.get(2), Double.parseDouble(parameters.get(3)))
                        .setBatteryCapacity(Integer.parseInt(parameters.get(4)))
                        .setDisplayInches(Double.parseDouble(parameters.get(5)))
                        .setMemoryRom(Integer.parseInt(parameters.get(6)))
                        .setFlashMemoryCapacity(Integer.parseInt(parameters.get(7)))
                        .setColor(parameters.get(8))
                        .build();
            case "VacuumCleaner":
                return new VacuumCleaner.VacuumCleanerBuilder(parameters.get(1), parameters.get(2), Double.parseDouble(parameters.get(3)))
                        .setPowerConsumption(Integer.parseInt(parameters.get(4)))
                        .setFilterType(parameters.get(5))
                        .setBagType(parameters.get(6))
                        .setWandType(parameters.get(7))
                        .setMotorSpeedRegulation(Integer.parseInt(parameters.get(8)))
                        .setCleaningWidth(Integer.parseInt(parameters.get(9)))
                        .build();
        }
        return null;
    }
}
