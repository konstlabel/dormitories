package com.konstl.dormitories.dormitory;

import com.konstl.dormitories.dormitory.dto.CreateDormitoryRequest;
import com.konstl.dormitories.dormitory.dto.DormitoryResponse;
import com.konstl.dormitories.dormitory.dto.DormitorySearchDto;
import com.konstl.dormitories.dormitory.dto.UpdateDormitoryRequest;
import com.konstl.dormitories.exception.resource.ResourceNotFoundException;
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
public class DormitoryServiceImpl implements DormitoryService {

    private final DormitoryRepository dormitoryRepository;
    private final DormitoryMapper dormitoryMapper;

    public DormitoryServiceImpl(DormitoryRepository dormitoryRepository, DormitoryMapper dormitoryMapper) {

        this.dormitoryRepository = dormitoryRepository;
        this.dormitoryMapper = dormitoryMapper;
    }

    @Override
    public DormitoryResponse findById(Long id) {

        Dormitory dormitory = dormitoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dormitory", "id", id));
        return dormitoryMapper.toResponse(dormitory);
    }

    @Override
    public PageResponse<DormitoryResponse> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Dormitory> result = dormitoryRepository.findAll(pageable);

        return buildPageResponse(result);
    }

    @Override
    public PageResponse<DormitoryResponse> search(DormitorySearchDto dto, int page, int size) {

        Specification<Dormitory> spec = DormitorySpecification.bySearch(dto);
        Page<Dormitory> result = dormitoryRepository.findAll(spec, PageRequest.of(page, size));

        return buildPageResponse(result);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public DormitoryResponse create(CreateDormitoryRequest createRequest) {

        Dormitory dormitory = dormitoryMapper.toEntity(createRequest);
        dormitory = dormitoryRepository.save(dormitory);
        return dormitoryMapper.toResponse(dormitory);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public DormitoryResponse update(Long id, UpdateDormitoryRequest updateRequest) {

        Dormitory dormitory = dormitoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Dormitory", "id", id));

        dormitoryMapper.updateEntityFromRequest(updateRequest, dormitory);
        dormitory = dormitoryRepository.save(dormitory);

        return dormitoryMapper.toResponse(dormitory);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN')")
    @Transactional
    public boolean delete(Long id) {

        if (!dormitoryRepository.existsById(id))
            throw new ResourceNotFoundException("Dormitory", "id", id);
        dormitoryRepository.deleteById(id);
        return true;
    }

    private PageResponse<DormitoryResponse> buildPageResponse(Page<Dormitory> result) {

        return PageResponse.<DormitoryResponse>builder()
                .content(dormitoryMapper.toResponseList(result.getContent()))
                .page(result.getNumber())
                .pageSize(result.getSize())
                .size(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .last(result.isLast())
                .build();
    }
}
