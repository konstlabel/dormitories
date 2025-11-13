package com.konstl.dormitories.agreement;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.konstl.dormitories.audit.UserDateAudit;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;
import java.time.LocalDate;

@Entity
@Table(name = "Agreements")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
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

    @Column(name = "move_in_date", nullable = false, updatable = false)
    private LocalDate moveInDate;

    @Column(name = "eviction_date", nullable = false)
    private LocalDate evictionDate;

    @Column(name = "cost", nullable = false)
    private Double cost;
}
