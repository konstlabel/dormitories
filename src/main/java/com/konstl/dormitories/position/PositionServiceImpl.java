package com.konstl.dormitories.position;

import com.konstl.dormitories.exception.resource.ResourceNotFoundException;
import com.konstl.dormitories.position.dto.CreatePositionRequest;
import com.konstl.dormitories.position.dto.PositionResponse;
import com.konstl.dormitories.position.dto.PositionSearchDto;
import com.konstl.dormitories.position.dto.UpdatePositionRequest;
import com.konstl.dormitories.utils.PageResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class PositionServiceImpl implements PositionService {

    private final PositionRepository positionRepository;
    private final PositionMapper positionMapper;

    public PositionServiceImpl(PositionRepository positionRepository, PositionMapper positionMapper) {

        this.positionRepository = positionRepository;
        this.positionMapper = positionMapper;
    }

    @Override
    public PositionResponse findById(Long id) {

        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position", "id", id));

        return positionMapper.toResponse(position);
    }

    @Override
    public PageResponse<PositionResponse> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Position> result = positionRepository.findAll(pageable);

        return buildPageResponse(result);
    }

    @Override
    public PageResponse<PositionResponse> findByName(String name, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Position> result = positionRepository.findByNameIgnoreCase(name, pageable);

        return buildPageResponse(result);
    }

    @Override
    public PageResponse<PositionResponse> search(PositionSearchDto searchDto, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Specification<Position> spec = PositionSpecification.withSearch(searchDto);
        Page<Position> result = positionRepository.findAll(spec, pageable);

        return buildPageResponse(result);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    public PositionResponse create(CreatePositionRequest createRequest) {

        Position position = positionMapper.toEntity(createRequest);
        position = positionRepository.save(position);

        return positionMapper.toResponse(position);

    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    public PositionResponse update(Long id, UpdatePositionRequest updateRequest) {

        Position position = positionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Position", "id", id));

        positionMapper.updateEntityFromRequest(updateRequest, position);
        position = positionRepository.save(position);

        return positionMapper.toResponse(position);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    public boolean delete(Long id) {

        if (!positionRepository.existsById(id))
            throw new ResourceNotFoundException("Agreement", "id", id);
        positionRepository.deleteById(id);
        return true;
    }

    private PageResponse<PositionResponse> buildPageResponse(Page<Position> result) {

        return PageResponse.<PositionResponse>builder()
                .content(positionMapper.toResponseList(result.getContent()))
                .page(result.getNumber())
                .pageSize(result.getSize())
                .size(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .last(result.isLast())
                .build();
    }
}
