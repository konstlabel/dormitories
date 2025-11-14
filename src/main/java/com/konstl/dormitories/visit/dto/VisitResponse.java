package com.konstl.dormitories.visit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisitResponse extends UserDateAuditDto {

    private Long id;

    private LocalDate date;

    private LocalDate startTime;

    private LocalDate endTime;

    private Long residentId;

    private Long visitorId;
}
