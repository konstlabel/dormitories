package com.konstl.dormitories.dormitory.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DormitoryResponse extends UserDateAuditDto {

    private Long id;

    private String name;

    private String address;
}
