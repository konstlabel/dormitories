package com.konstl.dormitories.position;

import com.konstl.dormitories.position.dto.PositionSearchDto;
import org.springframework.data.jpa.domain.Specification;
import jakarta.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;

public class PositionSpecification {

    public static Specification<Position> withSearch(PositionSearchDto dto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if(dto.getMin_salary() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("salary"), dto.getMin_salary()));
            }

            if(dto.getMax_salary() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("salary"), dto.getMax_salary()));
            }

            query.distinct(true);
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
