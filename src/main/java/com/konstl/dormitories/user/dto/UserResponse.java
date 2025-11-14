package com.konstl.dormitories.user.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.konstl.dormitories.audit.UserDateAuditDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse extends UserDateAuditDto {

    Long id;

    String username;

    String email;

    String roleName;
}
