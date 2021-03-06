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
	public List<Appliance> find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			throw new RuntimeException("Wrong parameters have been inputted!");
		}
		
		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();
		
		List<Appliance> appliances = applianceDAO.find(criteria);

		return appliances;
	}

}
