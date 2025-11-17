package com.konstl.dormitories.employee;

import com.konstl.dormitories.employee.dto.CreateEmployeeRequest;
import com.konstl.dormitories.employee.dto.EmployeeResponse;
import com.konstl.dormitories.employee.dto.UpdateEmployeeRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface EmployeeMapper {

    EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    EmployeeResponse toResponse(Employee Employee);

    Employee toEntity(CreateEmployeeRequest createRequest);

    void updateEntityFromRequest(UpdateEmployeeRequest updateRequest, @MappingTarget Employee Employee);

    List<EmployeeResponse> toResponseList(List<Employee> Employees);
}
