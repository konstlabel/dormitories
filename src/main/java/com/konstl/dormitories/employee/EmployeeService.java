package com.konstl.dormitories.employee;

import com.konstl.dormitories.employee.dto.CreateEmployeeRequest;
import com.konstl.dormitories.employee.dto.EmployeeResponse;
import com.konstl.dormitories.employee.dto.UpdateEmployeeRequest;
import com.konstl.dormitories.utils.PageResponse;

public interface EmployeeService {

    EmployeeResponse findById(Long id);

    PageResponse<EmployeeResponse> findAll(int page, int size);

    PageResponse<EmployeeResponse> findByFullName(String name, int page, int size);

    EmployeeResponse findByPhone(String phone);

    EmployeeResponse findByContractNumber(Long contractNumber);

    PageResponse<EmployeeResponse> findByDormitoryId(Long dormitoryId, int page, int size);

    PageResponse<EmployeeResponse> findByPositionId(Long positionId, int page, int size);

    PageResponse<EmployeeResponse> findByDormitoryIdAndPositionId(Long dormitoryId, Long positionId, int page, int size);

    EmployeeResponse create(CreateEmployeeRequest createRequest);

    EmployeeResponse update(Long id, UpdateEmployeeRequest updateRequest);

    boolean delete(Long id);
}
