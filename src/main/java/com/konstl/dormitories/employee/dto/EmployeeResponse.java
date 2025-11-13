package com.konstl.dormitories.employee.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class EmployeeResponse extends UserDateAuditDto {

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String phone;

    private Long contractNumber;

    private Long dormitoryId;

    private Long positionId;
}
