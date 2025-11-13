package com.konstl.dormitories.registration.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegistrationResponse extends UserDateAuditDto {

    private Long visitId;

    private Long paymentId;

    private Long employeeId;
}
