package com.konstl.dormitories.employee.dto;

import lombok.Data;

@Data
public class UpdateEmployeeRequest {

    private String firstName;

    private String middleName;

    private String lastName;

    private String phone;

    private Long contractNumber;

    private Long dormitoryId;

    private Long positionId;
}
