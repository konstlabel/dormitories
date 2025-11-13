package com.konstl.dormitories.room;

import com.konstl.dormitories.dormitory.DormitoryRepository;
import com.konstl.dormitories.dormitory.DormitoryServiceImpl;
import com.konstl.dormitories.room.dto.CreateRoomRequest;
import com.konstl.dormitories.room.dto.RoomResponse;
import com.konstl.dormitories.room.dto.UpdateRoomRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

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
    public Page<RoomResponse> findByRoomNumber(Integer roomNumber, Pageable pageable) {
        return null;
    }

    @Override
    public Page<RoomResponse> findByFloor(Integer floor, Pageable pageable) {
        return null;
    }

    @Override
    public Page<RoomResponse> findByCapacity(Integer capacity, Pageable pageable) {
        return null;
    }

    @Override
    public Page<RoomResponse> findByDormitoryId(Long dormitoryId, Pageable pageable) {
        return null;
    }

    @Override
    public Page<RoomResponse> findByDormitoryIdAndCapacity(Long dormitoryId, Integer capacity, Pageable pageable) {
        return null;
    }

    @Override
    public Page<RoomResponse> findByFloorAndCapacity(Integer floor, Integer capacity, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public RoomResponse create(CreateRoomRequest createRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public RoomResponse update(UpdateRoomRequest updateRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public RoomResponse delete(Long id) {
        return null;
    }
}
