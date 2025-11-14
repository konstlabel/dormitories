package com.konstl.dormitories.agreement.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class UpdateAgreementRequest {

    @NotNull
    private Long id;

    private LocalDate moveInDate;

    private LocalDate evictionDate;

    private BigDecimal cost;
}
