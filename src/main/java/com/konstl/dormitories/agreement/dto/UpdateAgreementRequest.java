package com.konstl.dormitories.agreement.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class UpdateAgreementRequest {

    private LocalDate moveInDate;

    private LocalDate evictionDate;

    private BigDecimal cost;
}
