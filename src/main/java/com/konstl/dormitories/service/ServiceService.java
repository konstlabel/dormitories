package com.konstl.dormitories.service;

import com.konstl.dormitories.service.dto.CreateServiceRequest;
import com.konstl.dormitories.service.dto.ServiceResponse;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public interface ServiceService {

    ServiceResponse findById(Long id);

    Page<ServiceResponse> findByEmployeeId(Long employeeId, Pageable pageable);

    Page<ServiceResponse> findByResidentId(Long residentId, Pageable pageable);

    Optional<ServiceResponse> findByEmployeeIdAndResidentId(Long employeeId, Long residentId);

    ServiceResponse create(CreateServiceRequest createRequest);

    ServiceResponse delete(Long id);
}
