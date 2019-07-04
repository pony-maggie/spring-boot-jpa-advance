package com.github.ponymaggie.jpa.service;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class MyTestSpec implements Specification {

    @Override
    public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
        Path id = root.get("id");
        Predicate predicate = criteriaBuilder.gt(id, 3);


        return  predicate;

    }
}
