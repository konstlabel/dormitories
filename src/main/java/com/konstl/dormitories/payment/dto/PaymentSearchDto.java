package com.konstl.dormitories.payment.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class PaymentSearchDto {

    LocalDateTime dateFrom;

    LocalDateTime dateTo;

    BigDecimal minAmount;

    BigDecimal maxAmount;

    Integer minPeriod;

    Integer maxPeriod;

    Long residentId;
}
