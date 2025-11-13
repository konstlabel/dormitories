package com.konstl.dormitories.employee.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateEmployeeRequest {

    @NotNull
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private String phone;

    private Long contractNumber;

    private Long dormitoryId;

    private Long positionId;
}
