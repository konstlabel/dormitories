package com.konstl.dormitories.registration.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegistrationSearchDto {

    private Long visitId;
    private Long paymentId;
    private Long employeeId;

    private Long residentId;

    private Long dormitoryId;
}
