package com.konstl.dormitories.room.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UpdateRoomRequest {

    @NotNull
    private Long id;

    private Integer roomNumber;

    private Integer floor;

    private Integer capacity;

    private Long dormitoryId;
}
