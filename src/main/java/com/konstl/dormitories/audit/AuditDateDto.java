package com.konstl.dormitories.audit;

import lombok.Data;

import java.time.Instant;

@Data
public abstract class AuditDateDto {

    private Instant createdAt;

    private Instant updatedAt;
}
