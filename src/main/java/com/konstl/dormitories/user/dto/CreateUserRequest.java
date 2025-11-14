package com.konstl.dormitories.user.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateUserRequest {

    @NotBlank
    String username;

    @NotBlank
    String email;

    @NotNull
    Long roleId;
}
