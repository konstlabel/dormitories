package com.konstl.dormitories.visit;

import com.konstl.dormitories.utils.PageResponse;
import com.konstl.dormitories.visit.dto.CreateVisitRequest;
import com.konstl.dormitories.visit.dto.UpdateVisitRequest;
import com.konstl.dormitories.visit.dto.VisitResponse;

import java.time.LocalDate;
import java.time.LocalTime;

public interface VisitService {

    VisitResponse findById(Long id);

    PageResponse<VisitResponse> findByDate(LocalDate date, int page, int size);

    PageResponse<VisitResponse> findByDateBetween(LocalDate startDate, LocalDate endDate, int page, int size);

    PageResponse<VisitResponse> findByStartTime(LocalTime time, int page, int size);

    PageResponse<VisitResponse> findByEndTime(LocalTime time, int page, int size);

    PageResponse<VisitResponse> findByDateAndStartTimeGreaterThanEqual(LocalDate date, LocalTime startTime, int page, int size);

    PageResponse<VisitResponse> findByDateAndEndTimeLessThanEqual(LocalDate date, LocalTime endTime, int page, int size);

    PageResponse<VisitResponse> findByStartTimeBetween(LocalTime startTime, LocalTime endTime, int page, int size);

    PageResponse<VisitResponse> findByEndTimeBetween(LocalTime startTime, LocalTime endTime, int page, int size);

    PageResponse<VisitResponse> findByResidentId(Long residentId, int page, int size);

    PageResponse<VisitResponse> findByVisitorId(Long visitorId, int page, int size);

    PageResponse<VisitResponse> findByResidentIdAndVisitorId(Long residentId, Long visitorId, int page, int size);

    PageResponse<VisitResponse> findByResidentIdAndDate(Long residentId, LocalDate date, int page, int size);

    PageResponse<VisitResponse> findByVisitorIdAndDate(Long visitorId, LocalDate date, int page, int size);

    VisitResponse create(CreateVisitRequest createRequest);

    VisitResponse update(UpdateVisitRequest updateRequest);

    VisitResponse delete(Long id);
}
