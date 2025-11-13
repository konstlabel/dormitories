package com.konstl.dormitories.visitor;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface VisitorRepository extends JpaRepository<Visitor, Long> {

    @Query("""
            Select v from Visitors v
            Where LOWER(v.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            """)
    Page<Visitor> findByFistName(@Param("first_name") String firstName, Pageable pageable);


    @Query("""
            Select v from Visitors v
            Where LOWER(v.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            """)
    Page<Visitor> findByMiddleName(@Param("middle_name") String middleName, Pageable pageable);

    @Query("""
            Select v from Visitors v
            Where LOWER(v.last_name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Visitor> findByLastName(@Param("last_name") String lastName, Pageable pageable);

    @Query("""
            Select v from Visitors v
            Where LOWER(v.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            AND LOWER(v.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            """)
    Page<Visitor> findByFirstNameAndMiddleName(@Param("first_name") String firstName,
                                               @Param("middle_name") String middleName,
                                               Pageable pageable);

    @Query("""
            Select v from Visitors v
            Where LOWER(v.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            AND LOWER(v.last_name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Visitor> findByFirstNameAndLastName(@Param("first_name") String firstName,
                                               @Param("last_name") String lastName,
                                               Pageable pageable);

    @Query("""
            Select v from Visitors v
            Where LOWER(v.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            AND LOWER(v.last_name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Visitor> findByMiddleNameAndLastName(@Param("middle_name") String middleName,
                                               @Param("last_name") String lastName,
                                               Pageable pageable);

    @Query("""
            Select v from Visitors v
            Where LOWER(v.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            OR LOWER(v.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            OR LOWER(v._name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Visitor> findByFullName(@Param("first_name") String firstName,
                                 @Param("middle_name") String middleName,
                                 @Param("last_name") String lastName,
                                 Pageable pageable);

    Page<Visitor> findByStatus(Boolean status, Pageable pageable);
}
