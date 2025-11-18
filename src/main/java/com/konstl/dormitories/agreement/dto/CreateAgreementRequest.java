package com.konstl.dormitories.agreement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class CreateAgreementRequest {

    @NotNull
    private LocalDate moveInDate;

    @NotNull
    private LocalDate evictionDate;

    @NotNull
    private BigDecimal cost;
}
