package com.konstl.dormitories.room;

import com.konstl.dormitories.room.dto.CreateRoomRequest;
import com.konstl.dormitories.room.dto.RoomResponse;
import com.konstl.dormitories.room.dto.UpdateRoomRequest;
import com.konstl.dormitories.utils.PageResponse;

public interface RoomService {

    RoomResponse findById(Long id);

    PageResponse<RoomResponse> findByRoomNumber(Integer roomNumber, int page, int size);

    PageResponse<RoomResponse> findByFloor(Integer floor, int page, int size);

    PageResponse<RoomResponse> findByCapacity(Integer capacity, int page, int size);

    PageResponse<RoomResponse> findByDormitoryId(Long dormitoryId, int page, int size);

    PageResponse<RoomResponse> findByDormitoryIdAndCapacity(Long dormitoryId, Integer capacity, int page, int size);

    PageResponse<RoomResponse> findByFloorAndCapacity(Integer floor, Integer capacity, int page, int size);

    RoomResponse create(CreateRoomRequest createRequest);

    RoomResponse update(UpdateRoomRequest updateRequest);

    RoomResponse delete(Long id);
}
