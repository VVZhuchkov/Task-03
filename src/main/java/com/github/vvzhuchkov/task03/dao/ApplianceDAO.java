package com.github.vvzhuchkov.task03.dao;

import com.github.vvzhuchkov.task03.entity.criteria.Criteria;

import java.util.List;

public interface ApplianceDAO {
	List<String> find(Criteria criteria);
}
