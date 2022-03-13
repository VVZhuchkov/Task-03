package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.dao.ApplianceDAO;
import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ApplianceDAOImpl implements ApplianceDAO {
    private Map<String, String> typedAppliances = new HashMap<>();
    private Map<String, String> parametersAppliance = new HashMap<>();

    @Override
    public Appliance find(Criteria criteria) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/appliances_db.txt"))) {
            String appliance = bufferedReader.readLine();
            String[] oneAppliance = parseTypeAppliance(appliance);
//            Object object = new

            } catch(FileNotFoundException fileNotFoundException){
                System.out.println("Connection to the database failed");
            } catch(IOException ioException){
                ioException.printStackTrace();
            }

            // you may add your own code here
            return null;
        }

        public String[] parseTypeAppliance (String appliance){
            String[] typeAppliance = appliance.split(" : ");
            return typeAppliance;
        }

        public void parseParameterAppliance (String appliance){
            String[] eachParameter = appliance.split(", ");
            for (String param : eachParameter) {
                String[] parameterValue = param.split("=");
                parametersAppliance.put(parameterValue[0], parameterValue[1]);
            }
        }

        // you may add your own code here

    }


//you may add your own new classes