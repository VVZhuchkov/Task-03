package com.github.vvzhuchkov.task03.dao;

import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {

	String databasePath();
	List<Appliance> find(Criteria criteria);
	List<String> readingParameters(String typeAppliance, String parametersAppliance);
}
