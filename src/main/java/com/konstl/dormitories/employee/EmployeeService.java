package com.konstl.dormitories.employee;

import com.konstl.dormitories.employee.dto.CreateEmployeeRequest;
import com.konstl.dormitories.employee.dto.EmployeeResponse;
import com.konstl.dormitories.employee.dto.EmployeeSearchDto;
import com.konstl.dormitories.employee.dto.UpdateEmployeeRequest;
import com.konstl.dormitories.utils.PageResponse;

public interface EmployeeService {

    EmployeeResponse findById(Long id);

    PageResponse<EmployeeResponse> findAll(int page, int size);

    PageResponse<EmployeeResponse> search(EmployeeSearchDto searchDto, int page, int size);

    EmployeeResponse create(CreateEmployeeRequest createRequest);

    EmployeeResponse update(Long id, UpdateEmployeeRequest updateRequest);

    boolean delete(Long id);
}
