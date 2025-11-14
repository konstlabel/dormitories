package com.konstl.dormitories.agreement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class CreateAgreementRequest {

    @NotNull
    private LocalDate moveInDate;

    @NotNull
    private LocalDate evictionDate;

    @NotNull
    private BigDecimal cost;
}
