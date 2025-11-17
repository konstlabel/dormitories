package com.konstl.dormitories.payment.dto;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class UpdatePaymentRequest {

    private LocalDateTime date;

    private BigDecimal amount;

    private Integer period;

    private Long residentId;
}
