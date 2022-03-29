package com.github.vvzhuchkov.task03.dao.impl;

import com.github.vvzhuchkov.task03.dao.ApplianceDAO;
import com.github.vvzhuchkov.task03.dao.ApplianceFactory;
import com.github.vvzhuchkov.task03.entity.*;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.github.vvzhuchkov.task03.dao.ApplianceFactory.applianceFactory;

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
                                        ApplianceFactory applianceFactory = new ApplianceFactory();
                                        appliances.add(applianceFactory(readingParameters(typeAppliance[0], typeAppliance[1])));
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
}
