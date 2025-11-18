package com.konstl.dormitories.employee;

import com.konstl.dormitories.employee.dto.CreateEmployeeRequest;
import com.konstl.dormitories.employee.dto.EmployeeResponse;
import com.konstl.dormitories.employee.dto.EmployeeSearchDto;
import com.konstl.dormitories.employee.dto.UpdateEmployeeRequest;
import com.konstl.dormitories.utils.PageResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {

        this.employeeService = employeeService;
    }

    @GetMapping
    public PageResponse<EmployeeResponse> findAll(@RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                  @RequestParam(defaultValue = "10") @Positive @Max(100) int size) {

        return employeeService.findAll(page, size);
    }

    @GetMapping("/{id}")
    public EmployeeResponse findById(@PathVariable Long id) {

        return employeeService.findById(id);
    }

    @GetMapping("/search")
    public PageResponse<EmployeeResponse> search(@ModelAttribute EmployeeSearchDto searchDto,
                                                 @RequestParam(defaultValue = "0") @PositiveOrZero int page,
                                                 @RequestParam(defaultValue = "10") @Positive @Max(100) int size) {

        return employeeService.search(searchDto, page, size);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or (hasRole('HEADER') and @employeeService.canAccessDormitory(#createRequest.dormitoryId, authentication.principal))")
    public ResponseEntity<EmployeeResponse> create(@Valid @RequestBody CreateEmployeeRequest createRequest) {

        EmployeeResponse created = employeeService.create(createRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or (hasRole('HEADER') and @employeeService.canAccess(#id, authentication.principal))")
    public EmployeeResponse update(@PathVariable Long id,
                                 @Valid @RequestBody UpdateEmployeeRequest updateRequest) {

        return employeeService.update(id, updateRequest);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or (hasRole('HEADER') and @employeeService.canAccess(#id, authentication.principal))")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public  void delete(@PathVariable Long id) {

        employeeService.delete(id);
    }
}
