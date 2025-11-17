package com.konstl.dormitories.registration;

import com.konstl.dormitories.registration.dto.RegistrationSearchDto;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class RegistrationSpecification {

    public static Specification<Registration> withSearch(RegistrationSearchDto dto) {
        return (root, query, cb) -> {
            List<Predicate> predicates = new ArrayList<>();

            // По составному ключу
            if (dto.getVisitId() != null) {
                predicates.add(cb.equal(root.get("id").get("visitId"), dto.getVisitId()));
            }
            if (dto.getPaymentId() != null) {
                predicates.add(cb.equal(root.get("id").get("paymentId"), dto.getPaymentId()));
            }
            if (dto.getEmployeeId() != null) {
                predicates.add(cb.equal(root.get("id").get("employeeId"), dto.getEmployeeId()));
            }

            if (dto.getResidentId() != null) {
                predicates.add(cb.equal(root.get("payment").get("resident").get("id"), dto.getResidentId()));
            }

            if (dto.getDormitoryId() != null) {
                predicates.add(cb.equal(root.get("employee").get("dormitory").get("id"), dto.getDormitoryId()));
            }

            query.distinct(true);
            return cb.and(predicates.toArray(new Predicate[0]));
        };
    }
}
