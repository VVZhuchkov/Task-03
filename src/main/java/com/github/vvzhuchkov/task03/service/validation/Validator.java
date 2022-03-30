package com.github.vvzhuchkov.task03.service.validation;

import com.github.vvzhuchkov.task03.entity.criteria.Criteria;
import com.github.vvzhuchkov.task03.entity.criteria.SearchCriteria;

public class Validator {

    public static boolean criteriaValidator(Criteria criteria) {
        Class<?>[] classes = SearchCriteria.class.getClasses();
        int coincidence = 0;
        int criteriasQuantity = criteria.getCriteria().size();
        for (Class numeration : classes) {
            if (criteria.getGroupSearchName().equals(numeration.getSimpleName())) {
                for (Object parameterEnum : numeration.getEnumConstants()) {
                    for (String criteriaParameterMap : criteria.getCriteria().keySet()) {
                        if (parameterEnum.equals(criteriaParameterMap)){
                            coincidence++;
                        }
                    }
                }

            }
        }
        Boolean checkParameter = (coincidence == criteriasQuantity)? true:false;
        return checkParameter;
    }
}