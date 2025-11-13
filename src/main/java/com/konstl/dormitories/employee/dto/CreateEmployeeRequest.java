package com.konstl.dormitories.employee.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateEmployeeRequest {

    @NotBlank
    private String firstName;

    @NotBlank
    private String middleName;

    @NotBlank
    private String lastName;

    @NotBlank
    private String phone;

    @NotNull
    private Long contractNumber;

    @NotNull
    private Long dormitoryId;

    @NotNull
    private Long positionId;
}
