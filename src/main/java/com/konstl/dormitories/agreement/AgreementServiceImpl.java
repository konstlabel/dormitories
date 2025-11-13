package com.konstl.dormitories.agreement;

import com.konstl.dormitories.agreement.dto.AgreementResponse;
import com.konstl.dormitories.agreement.dto.CreateAgreementRequest;
import com.konstl.dormitories.agreement.dto.UpdateAgreementRequest;
import com.konstl.dormitories.utils.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;

@Service
@Transactional(readOnly = true)
public class AgreementServiceImpl implements AgreementService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final AgreementRepository agreementRepository;

    public AgreementServiceImpl(AgreementRepository agreementRepository) {
        this.agreementRepository = agreementRepository;
    }

    @Override
    public AgreementResponse findById(Long id) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findAll(int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByMoveInDate(LocalDate date, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByEvictionDate(LocalDate date, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByCost(Double cost, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByMoveInDateGreaterThanEqual(LocalDate date, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByMoveInDateLessThanEqual(LocalDate date, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByEvictionDateGreaterThanEqual(LocalDate date, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByEvictionDateLessThanEqual(LocalDate date, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByMoveInDateBetween(LocalDate startDate, LocalDate endDate, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByEvictionDateBetween(LocalDate startDate, LocalDate endDate, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByCostBetween(Double startCost, Double endCost, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByCostGreaterThanEqual(Double cost, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<AgreementResponse> findByCostLessThanEqual(Double cost, int page, int size) {
        return null;
    }

    @Override
    public AgreementResponse create(CreateAgreementRequest createRequest) {
        return null;
    }

    @Override
    public AgreementResponse update(UpdateAgreementRequest updateRequest) {
        return null;
    }

    @Override
    public AgreementResponse delete(Long id) {
        return null;
    }
}
