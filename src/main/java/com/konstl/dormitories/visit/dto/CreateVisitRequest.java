package com.konstl.dormitories.visit.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.sql.Date;
import java.sql.Time;

@Data
public class CreateVisitRequest {

    @NotNull
    private Date date;

    @NotNull
    private Time startTime;

    @NotNull
    private Time endTime;

    @NotNull
    private Long residentId;

    @NotNull
    private Long visitorId;
}
