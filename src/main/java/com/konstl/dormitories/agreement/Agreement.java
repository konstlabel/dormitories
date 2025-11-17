package com.konstl.dormitories.agreement;

import com.konstl.dormitories.audit.UserDateAudit;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "Agreements")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Agreement extends UserDateAudit {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agreement_id", nullable = false, updatable = false, unique = true)
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name = "move_in_date", nullable = false)
    private LocalDate moveInDate;

    @EqualsAndHashCode.Include
    @Column(name = "eviction_date", nullable = false)
    private LocalDate evictionDate;

    @EqualsAndHashCode.Include
    @Column(name = "cost", nullable = false)
    private BigDecimal cost;
}
