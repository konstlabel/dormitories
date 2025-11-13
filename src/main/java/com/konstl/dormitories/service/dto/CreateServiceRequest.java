package com.konstl.dormitories.service.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateServiceRequest {

    @NotNull
    private Long employeeId;

    @NotNull
    private Long residentId;
}
