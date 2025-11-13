package com.konstl.dormitories.position;

import com.konstl.dormitories.position.dto.CreatePositionRequest;
import com.konstl.dormitories.position.dto.PositionResponse;
import com.konstl.dormitories.position.dto.UpdatePositionRequest;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;

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
    public Page<PositionResponse> findBySalary(Double salary, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Position> findBySalaryGreaterThanEqual(Double salary, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Position> findBySalaryLessThanEqual(Double salary, Pageable pageable) {
        return null;
    }

    @Override
    public Page<Position> findBySalaryBetween(Double startSalary, Double endSalary, Pageable pageable) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public PositionResponse create(CreatePositionRequest createRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public PositionResponse update(UpdatePositionRequest updateRequest) {
        return null;
    }

    @Override
    @Transactional(readOnly = false)
    public PositionResponse delete(Long id) {
        return null;
    }
}
