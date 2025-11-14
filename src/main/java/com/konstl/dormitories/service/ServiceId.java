package com.konstl.dormitories.service;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServiceId implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Column(name = "employee_id")
    private Long employeeId;

    @Column(name = "resident_id")
    private Long residentId;
}
