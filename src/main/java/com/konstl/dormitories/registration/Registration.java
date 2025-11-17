package com.konstl.dormitories.registration;

import com.konstl.dormitories.audit.UserDateAudit;
import com.konstl.dormitories.employee.Employee;
import com.konstl.dormitories.payment.Payment;
import com.konstl.dormitories.visit.Visit;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "Registration_of_Visits")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Registration extends UserDateAudit {

    @EmbeddedId
    private RegistrationId id;

    @MapsId("visitId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "visit_id", referencedColumnName = "visit_id", nullable = false)
    private Visit visit;

    @MapsId("paymentId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_id", referencedColumnName = "payment_id", nullable = false)
    private Payment payment;

    @MapsId("employeeId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id", referencedColumnName = "employee_id", nullable = false)
    private Employee employee;
}
