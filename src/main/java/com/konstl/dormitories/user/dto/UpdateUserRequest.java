package com.konstl.dormitories.user.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateUserRequest {

    @NotNull
    Long id;

    String username;

    String email;

    Long roleId;
}
