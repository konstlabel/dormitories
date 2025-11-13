package com.konstl.dormitories.resident.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResidentResponse extends UserDateAuditDto {

    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private Long roomId;

    private Long agreementId;
}
