package com.konstl.dormitories.employee;

import com.konstl.dormitories.dormitory.Dormitory;
import com.konstl.dormitories.dormitory.DormitoryRepository;
import com.konstl.dormitories.employee.dto.CreateEmployeeRequest;
import com.konstl.dormitories.employee.dto.EmployeeResponse;
import com.konstl.dormitories.employee.dto.EmployeeSearchDto;
import com.konstl.dormitories.employee.dto.UpdateEmployeeRequest;
import com.konstl.dormitories.exception.resource.ResourceNotFoundException;
import com.konstl.dormitories.position.Position;
import com.konstl.dormitories.position.PositionRepository;
import com.konstl.dormitories.security.CurrentUser.UserPrincipal;
import com.konstl.dormitories.utils.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final EmployeeRepository employeeRepository;
    private final DormitoryRepository dormitoryRepository;
    private final PositionRepository positionRepository;
    private final EmployeeMapper employeeMapper;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               DormitoryRepository dormitoryRepository,
                               PositionRepository positionRepository,
                               EmployeeMapper employeeMapper) {

        this.employeeRepository = employeeRepository;
        this.dormitoryRepository = dormitoryRepository;
        this.positionRepository = positionRepository;
        this.employeeMapper = employeeMapper;
    }

    @Override
    public EmployeeResponse findById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
        return employeeMapper.toResponse(employee);
    }

    @Override
    public PageResponse<EmployeeResponse> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Employee> result = employeeRepository.findAll(pageable);

        return buildPageResponse(result);
    }

    @Override
    public PageResponse<EmployeeResponse> search(EmployeeSearchDto searchDto, int page, int size) {

        Specification<Employee> spec = EmployeeSpecification.bySearch(searchDto);
        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Employee> result = employeeRepository.findAll(spec, pageable);

        return buildPageResponse(result);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or (hasRole('HEADER') and @employeeService.canAccessDormitory(#createRequest.dormitoryId, authentication.principal))")
    @Transactional
    public EmployeeResponse create(CreateEmployeeRequest createRequest) {

        Dormitory dormitory = dormitoryRepository.findById(createRequest.getDormitoryId())
                .orElseThrow(() -> new ResourceNotFoundException("Dormitory", "id", createRequest.getDormitoryId()));

        Position position = positionRepository.findById(createRequest.getPositionId())
                .orElseThrow(() -> new ResourceNotFoundException("Position", "id", createRequest.getPositionId()));

        Employee employee = employeeMapper.toEntity(createRequest);
        employee.setDormitory(dormitory);
        employee.setPosition(position);

        employee = employeeRepository.save(employee);
        return employeeMapper.toResponse(employee);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or (hasRole('HEADER') and @employeeService.canAccess(#id, authentication.principal))")
    @Transactional
    public EmployeeResponse update(Long id, UpdateEmployeeRequest updateRequest) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        employeeMapper.updateEntityFromRequest(updateRequest, employee);
        employee = employeeRepository.save(employee);

        return employeeMapper.toResponse(employee);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or (hasRole('HEADER') and @employeeService.canAccess(#id, authentication.principal))")
    @Transactional
    public boolean delete(Long id) {

        if (!employeeRepository.existsById(id))
            throw new ResourceNotFoundException("Employee", "id", id);
        employeeRepository.deleteById(id);
        return true;
    }

    private PageResponse<EmployeeResponse> buildPageResponse(Page<Employee> result) {

        return PageResponse.<EmployeeResponse>builder()
                .content(employeeMapper.toResponseList(result.getContent()))
                .page(result.getNumber())
                .pageSize(result.getSize())
                .size(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .last(result.isLast())
                .build();
    }

    /** SpEL: employee access **/
    @SuppressWarnings("unused")
    public boolean canAccess(Long employeeId, UserPrincipal user) {
        return employeeRepository.findById(employeeId)
                .map(emp -> {
                    Long dormId = emp.getDormitory().getId();
                    return user.getDormitoryId() != null && user.getDormitoryId().equals(dormId);
                })
                .orElse(false);
    }

    /** SpEL: dormitory header access **/
    @SuppressWarnings("unused")
    public boolean canAccessDormitory(Long dormitoryId, UserPrincipal user) {
        return dormitoryRepository.findById(dormitoryId)
                .map(dorm -> user.getDormitoryId() != null && user.getDormitoryId().equals(dorm.getId()))
                .orElse(false);
    }
}
