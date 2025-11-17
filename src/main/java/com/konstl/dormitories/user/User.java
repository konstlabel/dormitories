package com.konstl.dormitories.user;

import com.konstl.dormitories.audit.UserDateAudit;
import com.konstl.dormitories.dormitory.Dormitory;
import com.konstl.dormitories.role.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.NaturalId;

@Entity
@Table(name = "Users")
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends UserDateAudit {

    @EqualsAndHashCode.Include
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, updatable = false, unique = true)
    private Long id;

    @EqualsAndHashCode.Include
    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @EqualsAndHashCode.Include
    @Email
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @EqualsAndHashCode.Include
    @Column(name = "password")
    private String password;

    @NaturalId
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "dormitory_id", referencedColumnName = "dormitory_id")
    private Dormitory dormitory;
}
