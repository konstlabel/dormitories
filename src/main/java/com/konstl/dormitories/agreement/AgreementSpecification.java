package com.konstl.dormitories.agreement;

import com.konstl.dormitories.agreement.dto.AgreementSearchDto;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class AgreementSpecification {

    public static Specification<Agreement> withSearch(AgreementSearchDto dto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getMoveInDateFrom() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("moveInDate"), dto.getMoveInDateFrom()));
            }
            if (dto.getMoveInDateTo() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("moveInDate"), dto.getMoveInDateTo()));
            }

            if (dto.getEvictionDateFrom() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("evictionDate"), dto.getEvictionDateFrom()));
            }
            if (dto.getEvictionDateTo() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("evictionDate"), dto.getEvictionDateTo()));
            }

            if (dto.getCostMin() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("cost"), dto.getCostMin()));
            }
            if (dto.getCostMax() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("cost"), dto.getCostMax()));
            }

            query.distinct(true);
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
