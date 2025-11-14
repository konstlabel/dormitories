package com.konstl.dormitories.room;

import com.konstl.dormitories.dormitory.DormitoryRepository;
import com.konstl.dormitories.room.dto.CreateRoomRequest;
import com.konstl.dormitories.room.dto.RoomResponse;
import com.konstl.dormitories.room.dto.UpdateRoomRequest;
import com.konstl.dormitories.utils.PageResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class RoomServiceImpl implements RoomService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final RoomRepository roomRepository;
    private final DormitoryRepository dormitoryRepository;

    public RoomServiceImpl(RoomRepository roomRepository, DormitoryRepository dormitoryRepository) {

        this.roomRepository = roomRepository;
        this.dormitoryRepository = dormitoryRepository;
    }


    @Override
    public RoomResponse findById(Long id) {
        return null;
    }

    @Override
    public PageResponse<RoomResponse> findByRoomNumber(Integer roomNumber, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RoomResponse> findByFloor(Integer floor, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RoomResponse> findByCapacity(Integer capacity, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RoomResponse> findByDormitoryId(Long dormitoryId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RoomResponse> findByDormitoryIdAndCapacity(Long dormitoryId, Integer capacity, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<RoomResponse> findByFloorAndCapacity(Integer floor, Integer capacity, int page, int size) {
        return null;
    }

    @Override
    public RoomResponse create(CreateRoomRequest createRequest) {
        return null;
    }

    @Override
    public RoomResponse update(UpdateRoomRequest updateRequest) {
        return null;
    }

    @Override
    public RoomResponse delete(Long id) {
        return null;
    }
}
