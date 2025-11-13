package com.konstl.dormitories.room;

import com.konstl.dormitories.dormitory.Dormitory;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long> {

    Page<Room> findByRoomNumber(Integer roomNumber, Pageable pageable);

    Page<Room> findByFloor(Integer floor, Pageable pageable);

    Page<Room> findByCapacity(Integer capacity, Pageable pageable);

    Page<Room> findByDormitory(Dormitory dormitory, Pageable pageable);

    Page<Room> findByDormitoryAndCapacity(Dormitory dormitory, Integer capacity, Pageable pageable);

    Page<Room> findByFloorAndCapacity(Integer floor, Integer capacity, Pageable pageable);
}