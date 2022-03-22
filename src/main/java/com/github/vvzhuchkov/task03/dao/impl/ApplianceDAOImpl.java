package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.dao.ApplianceDAO;
import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {
    private final String databasePath = databasePath();

    @Override
    public String databasePath() {
        URL filePath = getClass().getClassLoader().getResource("appliances_db.txt");
        File file = null;
        try {
            file = Paths.get(filePath.toURI()).toFile();
        } catch (URISyntaxException e) {
            System.out.println("Incorrect path to file");
        }
        String databasePath = file.getAbsolutePath();
        return databasePath;
    }

    @Override
    public List<String> find(Criteria criteria) {
        List<String> appliances = new ArrayList<>();
        int coincidence = 0;
        String appliance;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(databasePath))) {
            while ((appliance = bufferedReader.readLine()) != null && !appliance.isEmpty()) {
                String[] typeAppliance = appliance.split(" : ");
                String[] parameters = typeAppliance[1].split(", ");
                if (typeAppliance[0].equals(criteria.getGroupSearchName())) {
                    for (Map.Entry<String, Object> oneCrit : criteria.getCriteria().entrySet()) {
                        String searchParameter = oneCrit.getKey() + "=" + oneCrit.getValue();
                        for (String parameter : parameters)
                            if (parameter.equals(searchParameter)) {
                                coincidence++;
                                if (coincidence == criteria.getCriteria().size()) {
                                    appliances.add(appliance);
                                }
                            }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return appliances;
    }
}
