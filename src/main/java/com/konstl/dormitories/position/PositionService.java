package com.konstl.dormitories.position;

import com.konstl.dormitories.position.dto.CreatePositionRequest;
import com.konstl.dormitories.position.dto.PositionResponse;
import com.konstl.dormitories.position.dto.PositionSearchDto;
import com.konstl.dormitories.position.dto.UpdatePositionRequest;
import com.konstl.dormitories.utils.PageResponse;

import java.math.BigDecimal;

public interface PositionService {

    PositionResponse findById(Long id);

    PageResponse<PositionResponse> findAll(int page, int size);

    PageResponse<PositionResponse> findByName(String name, int page, int size);

    PageResponse<PositionResponse> search(PositionSearchDto searchDto, int page, int size);

    PositionResponse create(CreatePositionRequest createRequest);

    PositionResponse update(Long id, UpdatePositionRequest updateRequest);

    boolean delete(Long id);
}
