package com.konstl.dormitories.room;

import com.konstl.dormitories.room.dto.CreateRoomRequest;
import com.konstl.dormitories.room.dto.RoomResponse;
import com.konstl.dormitories.room.dto.UpdateRoomRequest;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface RoomService {

    RoomResponse findById(Long id);

    Page<RoomResponse> findByRoomNumber(Integer roomNumber, Pageable pageable);

    Page<RoomResponse> findByFloor(Integer floor, Pageable pageable);

    Page<RoomResponse> findByCapacity(Integer capacity, Pageable pageable);

    Page<RoomResponse> findByDormitoryId(Long dormitoryId, Pageable pageable);

    Page<RoomResponse> findByDormitoryIdAndCapacity(Long dormitoryId, Integer capacity, Pageable pageable);

    Page<RoomResponse> findByFloorAndCapacity(Integer floor, Integer capacity, Pageable pageable);

    RoomResponse create(CreateRoomRequest createRequest);

    RoomResponse update(UpdateRoomRequest updateRequest);

    RoomResponse delete(Long id);
}
