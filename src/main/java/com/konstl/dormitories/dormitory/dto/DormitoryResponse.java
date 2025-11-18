package com.konstl.dormitories.dormitory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DormitoryResponse extends UserDateAuditDto {

    private Long id;

    private String name;

    private String address;
}
