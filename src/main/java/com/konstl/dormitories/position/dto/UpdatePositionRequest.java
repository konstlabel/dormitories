package com.konstl.dormitories.position.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdatePositionRequest {

    @NotNull
    private Long id;

    private String name;

    private BigDecimal salary;
}
