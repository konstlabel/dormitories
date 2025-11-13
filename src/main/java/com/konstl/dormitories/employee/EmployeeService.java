package com.konstl.dormitories.employee;

import com.konstl.dormitories.employee.dto.CreateEmployeeRequest;
import com.konstl.dormitories.employee.dto.EmployeeResponse;
import com.konstl.dormitories.employee.dto.UpdateEmployeeRequest;
import com.konstl.dormitories.utils.PageResponse;

public interface EmployeeService {

    EmployeeResponse findById(Long id);

    PageResponse<EmployeeResponse> findByFistName(String firstName, int page, int size);

    PageResponse<EmployeeResponse> findByMiddleName(String middleName, int page, int size);

    PageResponse<EmployeeResponse> findByLastName(String lastName, int page, int size);

    PageResponse<EmployeeResponse> findByFirstNameAndMiddleName(String firstName,
                                                        String middleName,
                                                        int page, int size);

    PageResponse<EmployeeResponse> findByFirstNameAndLastName(String firstName,
                                                      String lastName,
                                                      int page, int size);

    PageResponse<EmployeeResponse> findByMiddleNameAndLastName(String middleName,
                                                       String lastName,
                                                       int page, int size);

    PageResponse<EmployeeResponse> findByFullName(String firstName,
                                          String middleName,
                                          String lastName,
                                          int page, int size);

    EmployeeResponse findByPhone(String phone);

    EmployeeResponse findByContractNumber(Long contractNumber);

    PageResponse<EmployeeResponse> findByDormitoryId(Long dormitoryId, int page, int size);

    PageResponse<EmployeeResponse> findByPositionId(Long positionId, int page, int size);

    PageResponse<EmployeeResponse> findByDormitoryIdAndPositionId(Long dormitoryId,
                                                          Long positionId,
                                                          int page, int size);

    EmployeeResponse create(CreateEmployeeRequest createRequest);

    EmployeeResponse update(UpdateEmployeeRequest updateRequest);

    EmployeeResponse delete(Long id);
}
