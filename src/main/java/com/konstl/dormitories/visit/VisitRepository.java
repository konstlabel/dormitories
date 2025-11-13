package com.konstl.dormitories.visit;

import com.konstl.dormitories.resident.Resident;
import com.konstl.dormitories.visitor.Visitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.sql.Time;

@Repository
public interface VisitRepository extends JpaRepository<Visit, Long> {

    Page<Visit> findByDate(Date date, Pageable pageable);

    Page<Visit> findByDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<Visit> findByStartTime(Time time, Pageable pageable);

    Page<Visit> findByEndTime(Time time, Pageable pageable);

    Page<Visit> findByDateAndStartTimeGreaterThanEqual(Date date, Time startTime, Pageable pageable);

    Page<Visit> findByDateAndEndTimeLessThanEqual(Date date, Time endTime, Pageable pageable);

    Page<Visit> findByStartTimeBetween(Time startTime, Time endTime, Pageable pageable);

    Page<Visit> findByEndTimeBetween(Time startTime, Time endTime, Pageable pageable);

    Page<Visit> findByResident(Resident resident, Pageable pageable);

    Page<Visit> findByVisitor(Visitor visitor, Pageable pageable);

    Page<Visit> findByResidentAndVisitor(Resident resident, Visitor visitor, Pageable pageable);

    Page<Visit> findByResidentAndDate(Resident resident, Date date, Pageable pageable);

    Page<Visit> findByVisitorAndDate(Visitor visitor, Date date, Pageable pageable);
}
