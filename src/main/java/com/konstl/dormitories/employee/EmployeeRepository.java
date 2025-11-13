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
            Select e from Employees e
            Where LOWER(e.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            """)
    Page<Employee> findByFistName(@Param("first_name") String firstName, Pageable pageable);


    @Query("""
            Select e from Employees e
            Where LOWER(e.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            """)
    Page<Employee> findByMiddleName(@Param("middle_name") String middleName, Pageable pageable);

    @Query("""
            Select e from Employees e
            Where LOWER(e.last_name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Employee> findByLastName(@Param("last_name") String lastName, Pageable pageable);

    @Query("""
            Select e from Employees e
            Where LOWER(e.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            AND LOWER(e.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            """)
    Page<Employee> findByFirstNameAndMiddleName(@Param("first_name") String firstName,
                                               @Param("middle_name") String middleName,
                                               Pageable pageable);

    @Query("""
            Select e from Employees e
            Where LOWER(e.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            AND LOWER(e.last_name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Employee> findByFirstNameAndLastName(@Param("first_name") String firstName,
                                             @Param("last_name") String lastName,
                                             Pageable pageable);

    @Query("""
            Select e from Employees e
            Where LOWER(e.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            AND LOWER(e.last_name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Employee> findByMiddleNameAndLastName(@Param("middle_name") String middleName,
                                              @Param("last_name") String lastName,
                                              Pageable pageable);

    @Query("""
            Select e from Employees e
            Where LOWER(e.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            OR LOWER(e.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            OR LOWER(e._name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Employee> findByFullName(@Param("first_name") String firstName,
                                 @Param("middle_name") String middleName,
                                 @Param("last_name") String lastName,
                                 Pageable pageable);

    Optional<Employee> findByPhone(String phone);

    Optional<Employee> findByContractNumber(Long contractNumber);

    Page<Employee> findByDormitory(Dormitory dormitory, Pageable pageable);

    Page<Employee> findByPosition(Position position, Pageable pageable);

    Page<Employee> findByDormitoryAndPosition(Dormitory dormitory,
                                              Position position,
                                              Pageable pageable);
}
