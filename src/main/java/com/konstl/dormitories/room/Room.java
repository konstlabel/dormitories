package com.konstl.dormitories.room;

import com.konstl.dormitories.audit.UserDateAudit;
import com.konstl.dormitories.dormitory.Dormitory;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;

@Entity
@Table(name = "Rooms")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Room extends UserDateAudit {

    @Serial
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "room_number", nullable = false)
    private Integer roomNumber;

    @Column(name = "floor", nullable = false)
    private Integer floor;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dormitory_id", referencedColumnName = "dormitory_id")
    private Dormitory dormitory;
}
