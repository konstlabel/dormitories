package com.konstl.dormitories.registration;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository extends JpaRepository<Registration, RegistrationId>, JpaSpecificationExecutor<Registration> {

    @EntityGraph(attributePaths = {
            "visit",
            "payment",
            "payment.resident",
            "employee",
            "employee.dormitory"
    })
    Page<Registration> findAll(Specification<Registration> spec, Pageable pageable);
}