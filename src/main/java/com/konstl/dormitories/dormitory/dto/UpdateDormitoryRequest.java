package com.konstl.dormitories.dormitory.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateDormitoryRequest {

    @NotNull
    private Long id;

    private String name;

    private String address;
}
