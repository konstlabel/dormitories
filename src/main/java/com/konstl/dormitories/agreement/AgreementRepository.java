package com.konstl.dormitories.agreement;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, Long> {

    Page<Agreement> findByMoveInDate(LocalDate date, Pageable pageable);

    Page<Agreement> findByEvictionDate(LocalDate date, Pageable pageable);

    Page<Agreement> findByCost(Double cost, Pageable pageable);

    Page<Agreement> findByMoveInDateGreaterThanEqual(LocalDate date, Pageable pageable);

    Page<Agreement> findByMoveInDateLessThanEqual(LocalDate date, Pageable pageable);

    Page<Agreement> findByEvictionDateGreaterThanEqual(LocalDate date, Pageable pageable);

    Page<Agreement> findByEvictionDateLessThanEqual(LocalDate date, Pageable pageable);

    Page<Agreement> findByMoveInDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Agreement> findByEvictionDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Agreement> findByCostBetween(Double startCost, Double endCost, Pageable pageable);

    Page<Agreement> findByCostGreaterThanEqual(Double cost, Pageable pageable);

    Page<Agreement> findByCostLessThanEqual(Double cost, Pageable pageable);
}
