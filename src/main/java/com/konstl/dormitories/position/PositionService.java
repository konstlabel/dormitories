package com.konstl.dormitories.position;

import com.konstl.dormitories.position.dto.CreatePositionRequest;
import com.konstl.dormitories.position.dto.PositionResponse;
import com.konstl.dormitories.position.dto.UpdatePositionRequest;
import com.konstl.dormitories.utils.PageResponse;

import java.math.BigDecimal;

public interface PositionService {

    PositionResponse findById(Long id);

    PositionResponse findByName(String name);

    PageResponse<PositionResponse> findBySalary(BigDecimal salary, int page, int size);

    PageResponse<PositionResponse> findBySalaryGreaterThanEqual(BigDecimal salary, int page, int size);

    PageResponse<PositionResponse> findBySalaryLessThanEqual(BigDecimal salary, int page, int size);

    PageResponse<PositionResponse> findBySalaryBetween(BigDecimal startSalary, BigDecimal endSalary, int page, int size);

    PositionResponse create(CreatePositionRequest createRequest);

    PositionResponse update(UpdatePositionRequest updateRequest);

    PositionResponse delete(Long id);
}
