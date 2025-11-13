package com.konstl.dormitories.visit.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class UpdateVisitRequest {

    @NotNull
    private Long id;

    private Date date;

    private Time startTime;

    private Time endTime;

    private Long residentId;

    private Long visitorId;
}
