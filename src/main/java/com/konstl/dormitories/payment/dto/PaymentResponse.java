package com.konstl.dormitories.payment.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigDecimal;
import java.sql.Timestamp;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PaymentResponse extends UserDateAuditDto {

    private Long id;

    private Timestamp date;

    private BigDecimal amount;

    private Integer period;

    private Long residentId;
}
