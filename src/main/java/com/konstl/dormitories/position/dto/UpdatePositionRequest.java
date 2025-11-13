package com.konstl.dormitories.position.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdatePositionRequest {

    @NotNull
    private Long id;

    private String name;

    private Double salary;
}
