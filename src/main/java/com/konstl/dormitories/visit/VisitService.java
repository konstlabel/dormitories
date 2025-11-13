package com.konstl.dormitories.visit;

import com.konstl.dormitories.visit.dto.CreateVisitRequest;
import com.konstl.dormitories.visit.dto.UpdateVisitRequest;
import com.konstl.dormitories.visit.dto.VisitResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.sql.Time;

public interface VisitService {

    VisitResponse findById(Long id);

    Page<VisitResponse> findByDate(Date date, Pageable pageable);

    Page<VisitResponse> findByDateBetween(Date startDate, Date endDate, Pageable pageable);

    Page<VisitResponse> findByStartTime(Time time, Pageable pageable);

    Page<VisitResponse> findByEndTime(Time time, Pageable pageable);

    Page<VisitResponse> findByDateAndStartTimeGreaterThanEqual(Date date, Time startTime, Pageable pageable);

    Page<VisitResponse> findByDateAndEndTimeLessThanEqual(Date date, Time endTime, Pageable pageable);

    Page<VisitResponse> findByStartTimeBetween(Time startTime, Time endTime, Pageable pageable);

    Page<VisitResponse> findByEndTimeBetween(Time startTime, Time endTime, Pageable pageable);

    Page<VisitResponse> findByResidentId(Long residentId, Pageable pageable);

    Page<VisitResponse> findByVisitorId(Long visitorId, Pageable pageable);

    Page<VisitResponse> findByResidentIdAndVisitorId(Long residentId, Long visitorId, Pageable pageable);

    Page<VisitResponse> findByResidentAndDate(Long residentId, Date date, Pageable pageable);

    Page<VisitResponse> findByVisitorAndDate(Long visitorId, Date date, Pageable pageable);

    VisitResponse create(CreateVisitRequest createRequest);

    VisitResponse update(UpdateVisitRequest updateRequest);

    VisitResponse delete(Long id);
}
