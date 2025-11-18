package com.konstl.dormitories.agreement.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class UpdateAgreementRequest {

    private LocalDate moveInDate;

    private LocalDate evictionDate;

    private BigDecimal cost;
}
