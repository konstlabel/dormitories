package com.konstl.dormitories.position.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class PositionSearchDto {

    BigDecimal min_salary;

    BigDecimal max_salary;
}
