package com.konstl.dormitories.agreement;

import com.konstl.dormitories.agreement.dto.AgreementResponse;
import com.konstl.dormitories.agreement.dto.CreateAgreementRequest;
import com.konstl.dormitories.agreement.dto.UpdateAgreementRequest;
import com.konstl.dormitories.utils.PageResponse;

import java.math.BigDecimal;
import java.time.LocalDate;


public interface AgreementService {

    AgreementResponse findById(Long id);

    PageResponse<AgreementResponse> findAll(int page, int size);

    PageResponse<AgreementResponse> findByMoveInDate(LocalDate date, int page, int size);

    PageResponse<AgreementResponse> findByEvictionDate(LocalDate date, int page, int size);

    PageResponse<AgreementResponse> findByCost(BigDecimal cost, int page, int size);

    PageResponse<AgreementResponse> findByMoveInDateGreaterThanEqual(LocalDate date, int page, int size);

    PageResponse<AgreementResponse> findByMoveInDateLessThanEqual(LocalDate date, int page, int size);

    PageResponse<AgreementResponse> findByEvictionDateGreaterThanEqual(LocalDate date, int page, int size);

    PageResponse<AgreementResponse> findByEvictionDateLessThanEqual(LocalDate date, int page, int size);

    PageResponse<AgreementResponse> findByMoveInDateBetween(LocalDate startDate, LocalDate endDate, int page, int size);

    PageResponse<AgreementResponse> findByEvictionDateBetween(LocalDate startDate, LocalDate endDate, int page, int size);

    PageResponse<AgreementResponse> findByCostBetween(BigDecimal startCost, BigDecimal endCost, int page, int size);

    PageResponse<AgreementResponse> findByCostGreaterThanEqual(BigDecimal cost, int page, int size);

    PageResponse<AgreementResponse> findByCostLessThanEqual(BigDecimal cost, int page, int size);

    AgreementResponse create(CreateAgreementRequest createRequest);

    AgreementResponse update(UpdateAgreementRequest updateRequest);

    AgreementResponse delete(Long id);
}
