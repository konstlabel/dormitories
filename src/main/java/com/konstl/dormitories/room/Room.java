package com.konstl.dormitories.room;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.konstl.dormitories.audit.UserDateAudit;
import com.konstl.dormitories.dormitory.Dormitory;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serial;

@Entity
@Table(name = "Rooms")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class Room extends UserDateAudit {

    @Serial
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "room_id", nullable = false, updatable = false, unique = true)
    private Long id;

    @Column(name = "room_number", nullable = false, updatable = false)
    private Integer roomNumber;

    @Column(name = "floor", nullable = false, updatable = false)
    private Integer floor;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dormitory_id", referencedColumnName = "dormitory_id")
    private Dormitory dormitory;
}
