package com.konstl.dormitories.dormitory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DormitoryRepository extends JpaRepository<Dormitory, Long> {

    @Query("""
            Select d from Dormitory d
            Where LOWER(d.name) LIKE LOWER(CONCAT('%', :name, '%'))
            """)
    Page<Dormitory> findByNameContainingIgnoreCase(@Param("name")String name, Pageable pageable);

    @Query("""
            Select d from Dormitory d
            Where LOWER(d.address) LIKE LOWER(CONCAT('%', :address, '%'))
            """)
    Page<Dormitory> findByAddressContainingIgnoreCase(@Param("address")String address, Pageable pageable);
}
