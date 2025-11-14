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
            Select v from Visitor v
            Where LOWER(v.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            """)
    Page<Visitor> findByFirstName(@Param("firstName") String firstName, Pageable pageable);


    @Query("""
            Select v from Visitor v
            Where LOWER(v.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            """)
    Page<Visitor> findByMiddleName(@Param("middleName") String middleName, Pageable pageable);

    @Query("""
            Select v from Visitor v
            Where LOWER(v.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Visitor> findByLastName(@Param("lastName") String lastName, Pageable pageable);

    @Query("""
            Select v from Visitor v
            Where LOWER(v.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            AND LOWER(v.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            """)
    Page<Visitor> findByFirstNameAndMiddleName(@Param("firstName") String firstName,
                                               @Param("middleName") String middleName,
                                               Pageable pageable);

    @Query("""
            Select v from Visitor v
            Where LOWER(v.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            AND LOWER(v.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Visitor> findByFirstNameAndLastName(@Param("firstName") String firstName,
                                               @Param("lastName") String lastName,
                                               Pageable pageable);

    @Query("""
            Select v from Visitor v
            Where LOWER(v.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            AND LOWER(v.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Visitor> findByMiddleNameAndLastName(@Param("middleName") String middleName,
                                               @Param("lastName") String lastName,
                                               Pageable pageable);

    @Query("""
            Select v from Visitor v
            Where LOWER(v.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            AND LOWER(v.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            AND LOWER(v.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Visitor> findByFullName(@Param("firstName") String firstName,
                                 @Param("middleName") String middleName,
                                 @Param("lastName") String lastName,
                                 Pageable pageable);

    Page<Visitor> findByStatus(Boolean status, Pageable pageable);
}
