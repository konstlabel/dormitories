package com.konstl.dormitories.position;

import com.konstl.dormitories.position.dto.CreatePositionRequest;
import com.konstl.dormitories.position.dto.PositionResponse;
import com.konstl.dormitories.position.dto.UpdatePositionRequest;
import com.konstl.dormitories.utils.PageResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional(readOnly = true)
public class PositionServiceImpl implements PositionService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final PositionRepository positionRepository;

    public PositionServiceImpl(PositionRepository positionRepository) {

        this.positionRepository = positionRepository;
    }


    @Override
    public PositionResponse findById(Long id) {
        return null;
    }

    @Override
    public PositionResponse findByName(String name) {
        return null;
    }

    @Override
    public PageResponse<PositionResponse> findBySalary(BigDecimal salary, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<PositionResponse> findBySalaryGreaterThanEqual(BigDecimal salary, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<PositionResponse> findBySalaryLessThanEqual(BigDecimal salary, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<PositionResponse> findBySalaryBetween(BigDecimal startSalary, BigDecimal endSalary, int page, int size) {
        return null;
    }

    @Override
    public PositionResponse create(CreatePositionRequest createRequest) {
        return null;
    }

    @Override
    public PositionResponse update(UpdatePositionRequest updateRequest) {
        return null;
    }

    @Override
    public PositionResponse delete(Long id) {
        return null;
    }
}
