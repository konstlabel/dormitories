package com.konstl.dormitories.visit;

import com.konstl.dormitories.resident.ResidentRepository;
import com.konstl.dormitories.utils.PageResponse;
import com.konstl.dormitories.visit.dto.CreateVisitRequest;
import com.konstl.dormitories.visit.dto.UpdateVisitRequest;
import com.konstl.dormitories.visit.dto.VisitResponse;
import com.konstl.dormitories.visitor.VisitorRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalTime;

@Service
@Transactional(readOnly = true)
public class VisitServiceImpl implements VisitService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final VisitRepository visitRepository;
    private final ResidentRepository residentRepository;
    private final VisitorRepository visitorRepository;

    public VisitServiceImpl(VisitRepository visitRepository,
                            ResidentRepository residentRepository,
                            VisitorRepository visitorRepository) {

        this.visitRepository = visitRepository;
        this.residentRepository = residentRepository;
        this.visitorRepository = visitorRepository;
    }


    @Override
    public VisitResponse findById(Long id) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByDate(LocalDate date, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByDateBetween(LocalDate startDate, LocalDate endDate, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByStartTime(LocalTime time, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByEndTime(LocalTime time, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByDateAndStartTimeGreaterThanEqual(LocalDate date, LocalTime startTime, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByDateAndEndTimeLessThanEqual(LocalDate date, LocalTime endTime, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByStartTimeBetween(LocalTime startTime, LocalTime endTime, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByEndTimeBetween(LocalTime startTime, LocalTime endTime, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByResidentId(Long residentId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByVisitorId(Long visitorId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByResidentIdAndVisitorId(Long residentId, Long visitorId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByResidentIdAndDate(Long residentId, LocalDate date, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<VisitResponse> findByVisitorIdAndDate(Long visitorId, LocalDate date, int page, int size) {
        return null;
    }

    @Override
    public VisitResponse create(CreateVisitRequest createRequest) {
        return null;
    }

    @Override
    public VisitResponse update(UpdateVisitRequest updateRequest) {
        return null;
    }

    @Override
    public VisitResponse delete(Long id) {
        return null;
    }
}
