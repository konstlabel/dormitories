package com.konstl.dormitories.resident;

import com.konstl.dormitories.agreement.Agreement;
import com.konstl.dormitories.room.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository {

    @Query("""
            Select r from Residents r
            Where LOWER(r.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            """)
    Page<Resident> findByFistName(@Param("first_name") String firstName, Pageable pageable);


    @Query("""
            Select r from Residents r
            Where LOWER(r.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            """)
    Page<Resident> findByMiddleName(@Param("middle_name") String middleName, Pageable pageable);

    @Query("""
            Select r from Residents r
            Where LOWER(r.last_name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Resident> findByLastName(@Param("last_name") String lastName, Pageable pageable);

    @Query("""
            Select r from Residents r
            Where LOWER(r.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            AND LOWER(r.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            """)
    Page<Resident> findByFirstNameAndMiddleName(@Param("first_name") String firstName,
                                               @Param("middle_name") String middleName,
                                               Pageable pageable);

    @Query("""
            Select r from Residents r
            Where LOWER(r.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            AND LOWER(r.last_name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Resident> findByFirstNameAndLastName(@Param("first_name") String firstName,
                                             @Param("last_name") String lastName,
                                             Pageable pageable);

    @Query("""
            Select r from Residents r
            Where LOWER(r.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            AND LOWER(r.last_name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Resident> findByMiddleNameAndLastName(@Param("middle_name") String middleName,
                                              @Param("last_name") String lastName,
                                              Pageable pageable);

    @Query("""
            Select r from Residents r
            Where LOWER(r.first_name) LIKE LOWER(CONCAT('%', :first_name, '%'))
            OR LOWER(r.middle_name) LIKE LOWER(CONCAT('%', :middle_name, '%'))
            OR LOWER(r._name) LIKE LOWER(CONCAT('%', :last_name, '%'))
            """)
    Page<Resident> findByFullName(@Param("first_name") String firstName,
                                 @Param("middle_name") String middleName,
                                 @Param("last_name") String lastName,
                                 Pageable pageable);

    Page<Resident> findByRoom(Room room, Pageable pageable);

    Page<Resident> findByAgreement(Agreement agreement);
}
