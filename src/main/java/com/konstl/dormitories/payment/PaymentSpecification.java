package com.konstl.dormitories.payment;

import com.konstl.dormitories.payment.dto.PaymentSearchDto;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class PaymentSpecification {

    public static Specification<Payment> withSearch(PaymentSearchDto dto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (dto.getDateFrom() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("paymentDate"), dto.getDateFrom()));
            }
            if (dto.getDateTo() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("paymentDate"), dto.getDateTo()));
            }

            if (dto.getMinAmount() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("amount"), dto.getMinAmount()));
            }
            if (dto.getMaxAmount() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("amount"), dto.getMaxAmount()));
            }

            // Диапазон по месяцу (в пределах одного года или всех)
            if (dto.getMinPeriod() != null) {
                predicates.add(cb.greaterThanOrEqualTo(root.get("month"), dto.getMinPeriod()));
            }
            if (dto.getMaxPeriod() != null) {
                predicates.add(cb.lessThanOrEqualTo(root.get("month"), dto.getMaxPeriod()));
            }

            if (dto.getResidentId() != null) {
                predicates.add(cb.equal(root.get("resident").get("id"), dto.getResidentId()));
            }

            query.distinct(true);
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
