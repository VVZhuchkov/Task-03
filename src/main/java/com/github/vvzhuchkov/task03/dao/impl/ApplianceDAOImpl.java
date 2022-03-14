package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.dao.ApplianceDAO;
import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {

    @Override
    public List<String> find(Criteria criteria) {
        List<String> appliances = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/appliances_db.txt"))) {
            String appliance = bufferedReader.readLine();// мы не чекаем все строки
            String[] typeAppliance = appliance.split(" : ");
            String[] parameters = typeAppliance[1].split(", ");
            if (typeAppliance[0].equals(criteria.getGroupSearchName())) {
                for (Map.Entry<String, Object> oneCrit : criteria.getCriteria().entrySet()) {
                    String searchParameter = oneCrit.getKey() + "=" + oneCrit.getValue();
                    for (String parameter : parameters )
                    if (parameter.equals(searchParameter)) {
                        appliances.add(appliance);
                        return appliances;
                    }
                }
            }
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("Connection to the database failed");
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        // you may add your own code here
        return appliances;
    }
}
