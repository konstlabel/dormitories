package com.konstl.dormitories.position;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface PositionRepository extends JpaRepository<Position, Long> {

    @Query("""
            Select p from Positions p
            Where LOWER(p.name) LIKE LOWER(CONCAT('%', :name, '%'))
            """)
    Optional<Position> findByName(@Param("name") String name);

    Page<Position> findBySalary(Double salary, Pageable pageable);

    Page<Position> findBySalaryGreaterThanEqual(Double salary, Pageable pageable);

    Page<Position> findBySalaryLessThanEqual(Double salary, Pageable pageable);

    Page<Position> findBySalaryBetween(Double startSalary, Double endSalary, Pageable pageable);
}
