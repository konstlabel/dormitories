package com.konstl.dormitories.visit;

import com.konstl.dormitories.resident.ResidentRepository;
import com.konstl.dormitories.visit.dto.CreateVisitRequest;
import com.konstl.dormitories.visit.dto.UpdateVisitRequest;
import com.konstl.dormitories.visit.dto.VisitResponse;
import com.konstl.dormitories.visitor.VisitorRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.sql.Time;

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
    public Page<VisitResponse> findByDate(Date date, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByDateBetween(Date startDate, Date endDate, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByStartTime(Time time, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByEndTime(Time time, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByDateAndStartTimeGreaterThanEqual(Date date, Time startTime, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByDateAndEndTimeLessThanEqual(Date date, Time endTime, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByStartTimeBetween(Time startTime, Time endTime, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByEndTimeBetween(Time startTime, Time endTime, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByResidentId(Long residentId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByVisitorId(Long visitorId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByResidentIdAndVisitorId(Long residentId, Long visitorId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByResidentAndDate(Long residentId, Date date, Pageable pageable) {
        return null;
    }

    @Override
    public Page<VisitResponse> findByVisitorAndDate(Long visitorId, Date date, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public VisitResponse create(CreateVisitRequest createRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public VisitResponse update(UpdateVisitRequest updateRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public VisitResponse delete(Long id) {
        return null;
    }
}
