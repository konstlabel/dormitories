package com.konstl.dormitories.agreement.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AgreementResponse extends UserDateAuditDto {

    private Long id;

    private LocalDate moveInDate;

    private LocalDate evictionDate;

    private Double cost;
}
