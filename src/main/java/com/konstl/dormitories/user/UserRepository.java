package com.konstl.dormitories.user;

import com.konstl.dormitories.role.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    @Query("""
            Select u FROM User u
            WHERE LOWER(u.username) = LOWER(CONCAT('%', :name, '%'))
            OR LOWER(u.email) = LOWER(CONCAT('%', :name, '%'))
            """)
    Optional<User> findByUsernameOrEmail(@Param("name") String name);

    Page<User> findByRole(Role role);
}
