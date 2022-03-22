package com.github.vvzhuchkov.task03.dao;

import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.net.URISyntaxException;
import java.util.List;

public interface ApplianceDAO {

	String databasePath();
	List<String> find(Criteria criteria);
}
