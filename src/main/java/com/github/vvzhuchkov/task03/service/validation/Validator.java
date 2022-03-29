package com.github.vvzhuchkov.task03.service.validation;

import com.github.vvzhuchkov.task03.entity.criteria.Criteria;
import com.github.vvzhuchkov.task03.entity.criteria.SearchCriteria;

public class Validator {

    public static boolean criteriaValidator(Criteria criteria) {
        Class<?>[] classes = SearchCriteria.class.getClasses();
        String nameClass;
        for (String parameter : criteria.getCriteria().keySet()) {
            for (Class numeration : classes) {
                if (parameter.equals(numeration.getSimpleName())) {
                }
            }
        }
        return true;
    }
}