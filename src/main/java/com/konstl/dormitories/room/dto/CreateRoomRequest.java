package com.konstl.dormitories.room.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CreateRoomRequest {

    @NotNull
    private Integer roomNumber;

    @NotNull
    private Integer floor;

    @NotNull
    private Integer capacity;

    @NotNull
    private Long dormitoryId;
}
