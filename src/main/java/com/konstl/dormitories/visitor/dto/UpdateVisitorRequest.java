package com.konstl.dormitories.visitor.dto;

import jakarta.validation.constraints.NotNull;

public class UpdateVisitorRequest {

    @NotNull
    private Long id;

    private String middleName;

    private String lastName;

    private Boolean status;
}
