package com.konstl.dormitories.agreement;

import com.konstl.dormitories.agreement.dto.AgreementResponse;
import com.konstl.dormitories.agreement.dto.AgreementSearchDto;
import com.konstl.dormitories.agreement.dto.CreateAgreementRequest;
import com.konstl.dormitories.agreement.dto.UpdateAgreementRequest;
import com.konstl.dormitories.exception.resource.ResourceNotFoundException;
import com.konstl.dormitories.resident.ResidentRepository;
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
public class AgreementServiceImpl implements AgreementService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final AgreementRepository agreementRepository;
    private final AgreementMapper agreementMapper;

    public AgreementServiceImpl(AgreementRepository agreementRepository, AgreementMapper agreementMapper) {

        this.agreementRepository = agreementRepository;
        this.agreementMapper = agreementMapper;
    }

    @Override
    public AgreementResponse findById(Long id) {

        Agreement agreement = agreementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agreement", "id", id));

        return agreementMapper.toResponse(agreement);
    }

    @Override
    public PageResponse<AgreementResponse> findAll(int page, int size) {

        return search(new AgreementSearchDto(), page, size);
    }

    @Override
    public PageResponse<AgreementResponse> search(AgreementSearchDto searchDto, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Specification<Agreement> spec = AgreementSpecification.withSearch(searchDto);
        Page<Agreement> result = agreementRepository.findAll(spec, pageable);

        return PageResponse.<AgreementResponse>builder()
                .content(agreementMapper.toResponseList(result.getContent()))
                .page(page)
                .pageSize(size)
                .size(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .last(result.isLast())
                .build();
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    @Transactional
    public AgreementResponse create(CreateAgreementRequest createRequest) {

        Agreement agreement = agreementMapper.toEntity(createRequest);
        agreement = agreementRepository.save(agreement);

        return agreementMapper.toResponse(agreement);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    @Transactional
    public AgreementResponse update(Long id, UpdateAgreementRequest updateRequest) {

        Agreement agreement = agreementRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Agreement", "id", id));

        agreementMapper.updateEntityFromRequest(updateRequest, agreement);
        agreement = agreementRepository.save(agreement);

        return agreementMapper.toResponse(agreement);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    @Transactional
    public boolean delete(Long id) {

        if (!agreementRepository.existsById(id))
            throw new ResourceNotFoundException("Agreement", "id", id);
        agreementRepository.deleteById(id);
        return true;
    }
}
