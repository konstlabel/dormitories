package com.konstl.dormitories.position;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("""
            Select p from Position p
            Where LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))
            """)
    Page<Position> findByNameIgnoreCase(@Param("name") String name, Pageable pageable);

    Page<Position> findBySalary(BigDecimal salary, Pageable pageable);

    Page<Position> findBySalaryGreaterThanEqual(BigDecimal salary, Pageable pageable);

    Page<Position> findBySalaryLessThanEqual(BigDecimal salary, Pageable pageable);

    Page<Position> findBySalaryBetween(BigDecimal startSalary, BigDecimal endSalary, Pageable pageable);
}
