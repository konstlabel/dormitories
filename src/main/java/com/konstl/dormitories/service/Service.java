package com.konstl.dormitories.service;

import com.konstl.dormitories.audit.UserDateAudit;
import com.konstl.dormitories.employee.Employee;
import com.konstl.dormitories.resident.Resident;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;

@Entity
@Table(name = "Services")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Service extends UserDateAudit {

    @Serial
    private final static long serialVersionUID = 1L;

    @EmbeddedId
    private ServiceId id;

    @MapsId("employeeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
    private Employee employee;

    @MapsId("residentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id", referencedColumnName = "resident_id", nullable = false)
    private Resident resident;
}
