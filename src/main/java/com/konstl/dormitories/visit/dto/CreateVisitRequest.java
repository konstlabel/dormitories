package com.konstl.dormitories.visit.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateVisitRequest {

    @NotNull
    private LocalDate date;

    @NotNull
    private LocalDate startTime;

    @NotNull
    private LocalDate endTime;

    @NotNull
    private Long residentId;

    @NotNull
    private Long visitorId;
}
