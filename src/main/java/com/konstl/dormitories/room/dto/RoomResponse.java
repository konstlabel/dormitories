package com.konstl.dormitories.room.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RoomResponse extends UserDateAuditDto {

    private Long id;

    private Integer roomNumber;

    private Integer floor;

    private Integer capacity;

    private Long dormitoryId;
}
