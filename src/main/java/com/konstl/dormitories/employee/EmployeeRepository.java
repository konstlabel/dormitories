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
            Select e from Employee e
            Where LOWER(e.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            """)
    Page<Employee> findByFirstName(@Param("firstName") String firstName, Pageable pageable);


    @Query("""
            Select e from Employee e
            Where LOWER(e.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            """)
    Page<Employee> findByMiddleName(@Param("middleName") String middleName, Pageable pageable);

    @Query("""
            Select e from Employee e
            Where LOWER(e.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Employee> findByLastName(@Param("lastName") String lastName, Pageable pageable);

    @Query("""
            Select e from Employee e
            Where LOWER(e.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            AND LOWER(e.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            """)
    Page<Employee> findByFirstNameAndMiddleName(@Param("firstName") String firstName,
                                               @Param("middleName") String middleName,
                                               Pageable pageable);

    @Query("""
            Select e from Employee e
            Where LOWER(e.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            AND LOWER(e.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Employee> findByFirstNameAndLastName(@Param("firstName") String firstName,
                                             @Param("lastName") String lastName,
                                             Pageable pageable);

    @Query("""
            Select e from Employee e
            Where LOWER(e.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            AND LOWER(e.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Employee> findByMiddleNameAndLastName(@Param("middleName") String middleName,
                                              @Param("lastName") String lastName,
                                              Pageable pageable);

    @Query("""
            Select e from Employee e
            Where LOWER(e.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            AND LOWER(e.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            AND LOWER(e.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Employee> findByFullName(@Param("firstName") String firstName,
                                 @Param("middleName") String middleName,
                                 @Param("lastName") String lastName,
                                 Pageable pageable);

    Optional<Employee> findByPhone(String phone);

    Optional<Employee> findByContractNumber(Long contractNumber);

    Page<Employee> findByDormitory(Dormitory dormitory, Pageable pageable);

    Page<Employee> findByPosition(Position position, Pageable pageable);

    Page<Employee> findByDormitoryAndPosition(Dormitory dormitory,
                                              Position position,
                                              Pageable pageable);
}
