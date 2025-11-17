package com.konstl.dormitories.position.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class UpdatePositionRequest {

    private String name;

    private BigDecimal salary;
}
