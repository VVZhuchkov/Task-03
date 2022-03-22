package com.github.vvzhuchkov.task03.service;

import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceService {	
	
	List<Appliance> find(Criteria criteria);
	
}
