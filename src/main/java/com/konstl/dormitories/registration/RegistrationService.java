package com.konstl.dormitories.registration;

import com.konstl.dormitories.registration.dto.CreateRegistrationRequest;
import com.konstl.dormitories.registration.dto.RegistrationResponse;
import com.konstl.dormitories.utils.PageResponse;

public interface RegistrationService {

    RegistrationResponse findById(Long id);

    PageResponse<RegistrationResponse> findAll(int page, int size);

    PageResponse<RegistrationResponse> findByVisitId(Long visitId, int page, int size);

    PageResponse<RegistrationResponse> findByPaymentId(Long paymentId, int page, int size);

    PageResponse<RegistrationResponse> findByEmployeeId(Long employeeId, int page, int size);

    PageResponse<RegistrationResponse> findByVisitIdAndPaymentId(Long visitId, Long paymentId, int page, int size);

    PageResponse<RegistrationResponse> findByVisitIdAndEmployeeId(Long visitId, Long employeeId, int page, int size);

    PageResponse<RegistrationResponse> findByPaymentIdAndEmployeeId(Long paymentId, Long employeeId, int page, int size);

    RegistrationResponse findByVisitIdAndPaymentIdAndEmployeeId(Long visitId, Long paymentId, Long employeeId);

    RegistrationResponse create(CreateRegistrationRequest createRequest);

    RegistrationResponse delete(Long id);
}