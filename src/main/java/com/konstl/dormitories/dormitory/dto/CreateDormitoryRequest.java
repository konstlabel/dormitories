package com.konstl.dormitories.dormitory.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateDormitoryRequest {

    @NotBlank
    @Size(min = 10, max = 30)
    private String name;

    @NotBlank
    private String address;
}
