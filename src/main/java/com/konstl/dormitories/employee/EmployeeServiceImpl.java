package com.konstl.dormitories.employee;

import com.konstl.dormitories.dormitory.DormitoryRepository;
import com.konstl.dormitories.employee.dto.CreateEmployeeRequest;
import com.konstl.dormitories.employee.dto.EmployeeResponse;
import com.konstl.dormitories.employee.dto.UpdateEmployeeRequest;
import com.konstl.dormitories.position.PositionRepository;
import com.konstl.dormitories.utils.PageResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final EmployeeRepository employeeRepository;
    private final DormitoryRepository dormitoryRepository;
    private final PositionRepository positionRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DormitoryRepository dormitoryRepository,
                               PositionRepository positionRepository) {

        this.employeeRepository = employeeRepository;
        this.dormitoryRepository = dormitoryRepository;
        this.positionRepository = positionRepository;
    }


    @Override
    public EmployeeResponse findById(Long id) {
        return null;
    }

    @Override
    public PageResponse<EmployeeResponse> findByFirstName(String firstName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<EmployeeResponse> findByMiddleName(String middleName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<EmployeeResponse> findByLastName(String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<EmployeeResponse> findByFirstNameAndMiddleName(String firstName, String middleName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<EmployeeResponse> findByFirstNameAndLastName(String firstName, String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<EmployeeResponse> findByMiddleNameAndLastName(String middleName, String lastName, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<EmployeeResponse> findByFullName(String firstName, String middleName, String lastName, int page, int size) {
        return null;
    }

    @Override
    public EmployeeResponse findByPhone(String phone) {
        return null;
    }

    @Override
    public EmployeeResponse findByContractNumber(Long contractNumber) {
        return null;
    }

    @Override
    public PageResponse<EmployeeResponse> findByDormitoryId(Long dormitoryId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<EmployeeResponse> findByPositionId(Long positionId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<EmployeeResponse> findByDormitoryIdAndPositionId(Long dormitoryId, Long positionId, int page, int size) {
        return null;
    }

    @Override
    public EmployeeResponse create(CreateEmployeeRequest createRequest) {
        return null;
    }

    @Override
    public EmployeeResponse update(UpdateEmployeeRequest updateRequest) {
        return null;
    }

    @Override
    public EmployeeResponse delete(Long id) {
        return null;
    }
}
