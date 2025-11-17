package com.konstl.dormitories.employee;

import com.konstl.dormitories.dormitory.Dormitory;
import com.konstl.dormitories.position.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("""
        SELECT e FROM Employee e
        WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', :name, '%'))
           OR LOWER(e.middleName) LIKE LOWER(CONCAT('%', :name, '%'))
           OR LOWER(e.lastName) LIKE LOWER(CONCAT('%', :name, '%'))
        """)
    Page<Employee> findByFullNameContainingIgnoreCase(@Param("name") String name, Pageable pageable);

    Optional<Employee> findByPhone(String phone);

    Optional<Employee> findByContractNumber(Long contractNumber);

    Page<Employee> findByDormitory(Dormitory dormitory, Pageable pageable);

    Page<Employee> findByPosition(Position position, Pageable pageable);

    Page<Employee> findByDormitoryAndPosition(Dormitory dormitory,
                                              Position position,
                                              Pageable pageable);
}
