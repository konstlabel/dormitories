package com.konstl.dormitories.dormitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DormitoryRepository extends JpaRepository<Dormitory, Long> {

    @Query("""
            Select d from Dormitories d
            Where LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))
            """)
    Page<Dormitory> findByName(@Param("name")String name, Pageable pageable);

    @Query("""
            Select d from Dormitories d
            Where LOWER(d.address) LIKE LOWER(CONCAT('%', :address, '%'))
            """)
    Page<Dormitory> findByAddress(@Param("address")String address, Pageable pageable);
}
