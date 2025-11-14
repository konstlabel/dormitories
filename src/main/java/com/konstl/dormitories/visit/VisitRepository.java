package com.konstl.dormitories.visit;

import com.konstl.dormitories.resident.Resident;
import com.konstl.dormitories.visitor.Visitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Page<Visit> findByDate(LocalDate date, Pageable pageable);

    Page<Visit> findByDateBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Visit> findByStartTime(LocalTime time, Pageable pageable);

    Page<Visit> findByEndTime(LocalTime time, Pageable pageable);

    Page<Visit> findByDateAndStartTimeGreaterThanEqual(LocalDate date, LocalTime startTime, Pageable pageable);

    Page<Visit> findByDateAndEndTimeLessThanEqual(LocalDate date, LocalTime endTime, Pageable pageable);

    Page<Visit> findByStartTimeBetween(LocalTime startTime, LocalTime endTime, Pageable pageable);

    Page<Visit> findByEndTimeBetween(LocalTime startTime, LocalTime endTime, Pageable pageable);

    Page<Visit> findByResident(Resident resident, Pageable pageable);

    Page<Visit> findByVisitor(Visitor visitor, Pageable pageable);

    Page<Visit> findByResidentAndVisitor(Resident resident, Visitor visitor, Pageable pageable);

    Page<Visit> findByResidentAndDate(Resident resident, LocalDate date, Pageable pageable);

    Page<Visit> findByVisitorAndDate(Visitor visitor, LocalDate date, Pageable pageable);
}
