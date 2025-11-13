package com.konstl.dormitories.service;

import com.konstl.dormitories.service.dto.CreateServiceRequest;
import com.konstl.dormitories.service.dto.ServiceResponse;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.Optional;

public class ServiceServiceImpl implements ServiceService {
    @Override
    public ServiceResponse findById(Long id) {
        return null;
    }

    @Override
    public Page<ServiceResponse> findByEmployeeId(Long employeeId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ServiceResponse> findByResidentId(Long residentId, Pageable pageable) {
        return null;
    }

    @Override
    public Optional<ServiceResponse> findByEmployeeIdAndResidentId(Long employeeId, Long residentId) {
        return Optional.empty();
    }

    @Override
    public ServiceResponse create(CreateServiceRequest createRequest) {
        return null;
    }

    @Override
    public ServiceResponse delete(Long id) {
        return null;
    }
}
