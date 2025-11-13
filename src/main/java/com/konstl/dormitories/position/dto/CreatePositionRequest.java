package com.konstl.dormitories.position.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CreatePositionRequest {

    @NotBlank
    @Size(min = 8, max = 50)
    private String name;

    @NotNull
    private Double salary;
}
