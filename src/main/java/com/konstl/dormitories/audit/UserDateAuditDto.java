package com.konstl.dormitories.audit;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class UserDateAuditDto extends AuditDateDto {

    private Long createdBy;

    private Long updatedBy;
}