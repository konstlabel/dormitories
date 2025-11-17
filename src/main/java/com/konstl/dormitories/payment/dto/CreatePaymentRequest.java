package com.konstl.dormitories.payment.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class CreatePaymentRequest {

    @NotNull
    private LocalDateTime date;

    @NotNull
    private BigDecimal amount;

    @NotNull
    @Size(min = 1, max = 12)
    private Integer period;

    @NotNull
    private Long residentId;
}
