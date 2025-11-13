package com.konstl.dormitories.registration.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateRegistrationRequest {

    @NotNull
    private Long visitId;

    @NotNull
    private Long paymentId;

    @NotNull
    private Long employeeId;
}
