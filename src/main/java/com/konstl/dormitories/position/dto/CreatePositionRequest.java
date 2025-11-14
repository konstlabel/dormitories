package com.konstl.dormitories.position.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CreatePositionRequest {

    @NotBlank
    @Size(min = 8, max = 50)
    private String name;

    @NotNull
    private BigDecimal salary;
}
