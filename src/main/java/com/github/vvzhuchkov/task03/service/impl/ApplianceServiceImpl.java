package com.github.vvzhuchkov.task03.service.impl;

import com.github.vvzhuchkov.task03.dao.ApplianceDAO;
import com.github.vvzhuchkov.task03.dao.DAOFactory;
import com.github.vvzhuchkov.task03.entity.Appliance;
import com.github.vvzhuchkov.task03.entity.criteria.Criteria;
import com.github.vvzhuchkov.task03.service.ApplianceService;
import com.github.vvzhuchkov.task03.service.validation.Validator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService {

	@Override
	public List<String> find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		List<String> appliances = applianceDAO.find(criteria);
		
		// you may add your own code here
		
		return appliances;
	}

}

//you may add your own new classes
