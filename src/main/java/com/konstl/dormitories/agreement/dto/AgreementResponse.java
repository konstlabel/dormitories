package com.konstl.dormitories.agreement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgreementResponse extends UserDateAuditDto {

    private Long id;

    private LocalDate moveInDate;

    private LocalDate evictionDate;

    private BigDecimal cost;
}
