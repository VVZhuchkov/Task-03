package com.github.vvzhuchkov.task03.dao;

import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.io.InputStream;
import java.util.List;

public interface ApplianceDAO {

	InputStream databasePath();
	List<Appliance> find(Criteria criteria);
	List<String> readingParameters(String typeAppliance, String parametersAppliance);
}
