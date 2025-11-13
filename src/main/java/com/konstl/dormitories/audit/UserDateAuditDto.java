package com.konstl.dormitories.audit;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public abstract class UserDateAuditDto extends AuditDateDto {

    private Long createdBy;

    private Long updatedBy;
}