package com.konstl.dormitories.registration;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationId implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "visit_id")
    private Long visitId;

    @Column(name = "paymentId")
    private Long paymentId;

    @Column(name = "employee_id")
    private Long employeeId;
}
