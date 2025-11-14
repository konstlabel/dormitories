package com.konstl.dormitories.payment.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Timestamp;

@Data
public class UpdatePaymentRequest {


    @NotNull
    private Long id;

    private Timestamp date;

    private BigDecimal amount;

    private Integer period;

    private Long residentId;
}
