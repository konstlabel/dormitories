package com.konstl.dormitories.visit.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateVisitRequest {

    @NotNull
    private Long id;

    private LocalDate date;

    private LocalDate startTime;

    private LocalDate endTime;

    private Long residentId;

    private Long visitorId;
}
