package com.konstl.dormitories.position;

import com.konstl.dormitories.position.dto.CreatePositionRequest;
import com.konstl.dormitories.position.dto.PositionResponse;
import com.konstl.dormitories.position.dto.UpdatePositionRequest;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface PositionService {

    PositionResponse findById(Long id);

    PositionResponse findByName(String name);

    Page<PositionResponse> findBySalary(Double salary, Pageable pageable);

    Page<Position> findBySalaryGreaterThanEqual(Double salary, Pageable pageable);

    Page<Position> findBySalaryLessThanEqual(Double salary, Pageable pageable);

    Page<Position> findBySalaryBetween(Double startSalary, Double endSalary, Pageable pageable);

    PositionResponse create(CreatePositionRequest createRequest);

    PositionResponse update(UpdatePositionRequest updateRequest);

    PositionResponse delete(Long id);
}
