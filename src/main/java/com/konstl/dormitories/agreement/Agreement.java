package com.konstl.dormitories.agreement;

import com.konstl.dormitories.audit.UserDateAudit;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Agreements")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agreement extends UserDateAudit {

    @Serial
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agreement_id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "move_in_date", nullable = false)
    private LocalDate moveInDate;

    @Column(name = "eviction_date", nullable = false)
    private LocalDate evictionDate;

    @Column(name = "cost", nullable = false)
    private BigDecimal cost;
}
