package com.konstl.dormitories.audit;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public abstract class AuditDateDto {

    private Instant createdAt;

    private Instant updatedAt;
}
