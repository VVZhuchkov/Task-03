package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.dao.ApplianceDAO;
import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.Oven;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {
    private final String databasePath = databasePath();

    @Override
    public String databasePath() {
        String databasePath = new File("").getAbsolutePath() + File.separator + "src" + File.separator +
                "main" + File.separator + "resources" + File.separator + "appliances_db.txt";
        return databasePath;
    }

    /*@Override
    public String databasePath() {
        URL filePath = getClass().getClassLoader().getResource("appliances_db.txt");
        System.out.println(filePath);
        File file = null;
        try {
            file = Paths.get(filePath.toURI()).toFile();
        } catch (URISyntaxException e) {
            System.out.println("Incorrect path to file");
        }
        String databasePath = file.getAbsolutePath();
        return databasePath;
    }*/

    /*@Override
    public String readingTypeAppliance(Criteria criteria) {
        String appliance;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(databasePath))) {
            while ((appliance = bufferedReader.readLine()) != null)
                while (!appliance.isEmpty()) {
                    String[] typeAppliance = appliance.split(" : ");
                    if (typeAppliance[0].equals(criteria.getGroupSearchName())) {
                        return typeAppliance[1];
                    }
                }
        } catch (FileNotFoundException e) {
            System.out.println("Database connection error");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }*/

    @Override
    public List<String> readingParameters(String typeAppliance, String parametersAppliance) {
        List<String> parameters = new ArrayList<>();
        parameters.add(typeAppliance);
        StringBuilder stringBuilder = new StringBuilder();
        char[] valuesAppliance = parametersAppliance.toCharArray();
        for (int i = 0; i < valuesAppliance.length; i++) {
            if (valuesAppliance[i] == '=') {
                i++;
                while (valuesAppliance[i] != ',' && i < valuesAppliance.length-1) {
                    stringBuilder.append(valuesAppliance[i]);
                    i++;
                }
                parameters.add(stringBuilder.toString());
                stringBuilder = new StringBuilder();
            }
        }
        return parameters;
    }

    public Appliance createAppliance(List<String> parameters) {
        for (String par : parameters){
            System.out.println(par);}
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
        }
        return null;
    }


    @Override
    public List<Appliance> find(Criteria criteria) {
        List<Appliance> appliances = new ArrayList<>();
        int coincidence = 0;
        String appliance;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(databasePath))) {
            while ((appliance = bufferedReader.readLine()) != null) {
                while (!appliance.isEmpty()) {
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
}
