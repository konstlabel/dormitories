package com.konstl.dormitories.agreement.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
public class AgreementSearchDto {

    private LocalDate moveInDateFrom;

    private LocalDate moveInDateTo;

    private LocalDate evictionDateFrom;

    private LocalDate evictionDateTo;

    private BigDecimal costMin;

    private BigDecimal costMax;
}
