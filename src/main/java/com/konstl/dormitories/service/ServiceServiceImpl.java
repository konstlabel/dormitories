package com.konstl.dormitories.service;

import com.konstl.dormitories.employee.EmployeeRepository;
import com.konstl.dormitories.resident.ResidentRepository;
import com.konstl.dormitories.resident.ResidentService;
import com.konstl.dormitories.service.dto.CreateServiceRequest;
import com.konstl.dormitories.service.dto.ServiceResponse;
import com.konstl.dormitories.utils.PageResponse;

public class ServiceServiceImpl implements ServiceService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final EmployeeRepository employeeRepository;
    private final ResidentRepository residentRepository;

    public ServiceServiceImpl(EmployeeRepository employeeRepository,
                              ResidentRepository residentRepository) {

        this.employeeRepository = employeeRepository;
        this. residentRepository = residentRepository;
    }

    @Override
    public ServiceResponse findById(Long id) {
        return null;
    }

    @Override
    public PageResponse<ServiceResponse> findByEmployeeId(Long employeeId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<ServiceResponse> findByResidentId(Long residentId, int page, int size) {
        return null;
    }

    @Override
    public ServiceResponse findByEmployeeIdAndResidentId(Long employeeId, Long residentId) {
        return null;
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
