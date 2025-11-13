package com.konstl.dormitories.visit.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.sql.Date;
import java.sql.Time;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class VisitResponse extends UserDateAuditDto {

    private Long id;

    private Date date;

    private Time startTime;

    private Time endTime;

    private Long residentId;

    private Long visitorId;
}
