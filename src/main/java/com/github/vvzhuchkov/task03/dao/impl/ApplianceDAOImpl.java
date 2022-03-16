package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.dao.ApplianceDAO;
import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public List<String> find(Criteria criteria) {
        List<String> appliances = new ArrayList<>();
        URL filePath = getClass().getClassLoader().getResource("appliances_db.txt");
        File file = null;
        try {
            file = Paths.get(filePath.toURI()).toFile();
        } catch (URISyntaxException e) {
            System.out.println("Incorrect path to file");
        }
        String absolutePath = file.getAbsolutePath();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(absolutePath))) {
            String appliance = bufferedReader.readLine();
            while (appliance != null) {
                while (appliance.isEmpty()) {// мы не чекаем все строки
                    appliance = bufferedReader.readLine();
                }
                int coincidence = 0;
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
                appliance = bufferedReader.readLine();
            }
            return appliances;
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        // you may add your own code here
        return appliances;
    }
}
