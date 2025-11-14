package com.konstl.dormitories.service;

import com.konstl.dormitories.service.dto.CreateServiceRequest;
import com.konstl.dormitories.service.dto.ServiceResponse;
import com.konstl.dormitories.utils.PageResponse;

public interface ServiceService {

    ServiceResponse findById(Long id);

    PageResponse<ServiceResponse> findByEmployeeId(Long employeeId, int page, int size);

    PageResponse<ServiceResponse> findByResidentId(Long residentId, int page, int size);

    ServiceResponse findByEmployeeIdAndResidentId(Long employeeId, Long residentId);

    ServiceResponse create(CreateServiceRequest createRequest);

    ServiceResponse delete(Long id);
}
