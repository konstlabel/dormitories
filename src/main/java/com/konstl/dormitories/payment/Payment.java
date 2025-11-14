package com.konstl.dormitories.payment;

import com.konstl.dormitories.audit.UserDateAudit;
import com.konstl.dormitories.resident.Resident;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "Payments")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Payment extends UserDateAudit {

    @Serial
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "date", nullable = false)
    private Timestamp date;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "period", nullable = false)
    private Integer period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "resident_id", referencedColumnName = "resident_id", nullable = false)
    private Resident resident;
}
