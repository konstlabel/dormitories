package com.konstl.dormitories.resident;

import com.konstl.dormitories.agreement.Agreement;
import com.konstl.dormitories.room.Room;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ResidentRepository extends JpaRepository<Resident, Long> {

    @Query("""
            Select r from Resident r
            Where LOWER(r.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            """)
    Page<Resident> findByFirstName(@Param("firstName") String firstName, Pageable pageable);


    @Query("""
            Select r from Resident r
            Where LOWER(r.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            """)
    Page<Resident> findByMiddleName(@Param("middleName") String middleName, Pageable pageable);

    @Query("""
            Select r from Resident r
            Where LOWER(r.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Resident> findByLastName(@Param("lastName") String lastName, Pageable pageable);

    @Query("""
            Select r from Resident r
            Where LOWER(r.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            AND LOWER(r.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            """)
    Page<Resident> findByFirstNameAndMiddleName(@Param("firstName") String firstName,
                                               @Param("middleName") String middleName,
                                               Pageable pageable);

    @Query("""
            Select r from Resident r
            Where LOWER(r.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            AND LOWER(r.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Resident> findByFirstNameAndLastName(@Param("firstName") String firstName,
                                             @Param("lastName") String lastName,
                                             Pageable pageable);

    @Query("""
            Select r from Resident r
            Where LOWER(r.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            AND LOWER(r.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Resident> findByMiddleNameAndLastName(@Param("middleName") String middleName,
                                              @Param("lastName") String lastName,
                                              Pageable pageable);

    @Query("""
            Select r from Resident r
            Where LOWER(r.firstName) LIKE LOWER(CONCAT('%', :firstName, '%'))
            AND LOWER(r.middleName) LIKE LOWER(CONCAT('%', :middleName, '%'))
            AND LOWER(r.lastName) LIKE LOWER(CONCAT('%', :lastName, '%'))
            """)
    Page<Resident> findByFullName(@Param("firstName") String firstName,
                                 @Param("middleName") String middleName,
                                 @Param("lastName") String lastName,
                                 Pageable pageable);

    Page<Resident> findByRoom(Room room, Pageable pageable);

    Page<Resident> findByAgreement(Agreement agreement, Pageable pageable);
}
