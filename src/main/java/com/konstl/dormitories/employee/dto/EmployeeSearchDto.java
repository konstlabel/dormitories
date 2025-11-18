package com.konstl.dormitories.employee.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeSearchDto {

    private String name;

    private String phone;

    private Long contractNumber;

    private Long dormitoryId;

    private Long positionId;
}
