package com.konstl.dormitories.resident.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateResidentRequest {

    @NotNull
    private Long id;

    private String firstName;

    private String middleName;

    private String lastName;

    private Long roomId;

    private Long agreementId;
}
