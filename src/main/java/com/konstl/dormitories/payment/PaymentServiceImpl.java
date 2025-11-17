package com.konstl.dormitories.payment;

import com.konstl.dormitories.exception.resource.ResourceNotFoundException;
import com.konstl.dormitories.payment.dto.CreatePaymentRequest;
import com.konstl.dormitories.payment.dto.PaymentResponse;
import com.konstl.dormitories.payment.dto.PaymentSearchDto;
import com.konstl.dormitories.payment.dto.UpdatePaymentRequest;
import com.konstl.dormitories.resident.Resident;
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
public class PaymentServiceImpl implements PaymentService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final PaymentRepository paymentRepository;
    private final ResidentRepository residentRepository;
    private final PaymentMapper paymentMapper;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              ResidentRepository residentRepository, PaymentMapper paymentMapper) {

        this.paymentRepository = paymentRepository;
        this.residentRepository = residentRepository;
        this.paymentMapper = paymentMapper;
    }


    @Override
    public PaymentResponse findById(Long id) {

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "id", id));

        return paymentMapper.toResponse(payment);
    }

    @Override
    public PageResponse<PaymentResponse> findAll(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Page<Payment> result = paymentRepository.findAll(pageable);

        return buildPageResponse(result);
    }

    @Override
    public PageResponse<PaymentResponse> search(PaymentSearchDto searchDto, int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("id").ascending());
        Specification<Payment> spec = PaymentSpecification.withSearch(searchDto);
        Page<Payment> result = paymentRepository.findAll(spec, pageable);

        return buildPageResponse(result);
    }

    @Override
    public PaymentResponse create(CreatePaymentRequest createRequest) {

        Payment payment = paymentMapper.toEntity(createRequest);
        payment = paymentRepository.save(payment);

        return paymentMapper.toResponse(payment);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    public PaymentResponse update(Long id, UpdatePaymentRequest updateRequest) {

        Resident resident = residentRepository.findById(updateRequest.getResidentId())
                .orElseThrow(() -> new ResourceNotFoundException("Resident", "id", id));

        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Payment", "id", id));

        paymentMapper.updateEntityFromRequest(updateRequest, payment);
        payment = paymentRepository.save(payment);

        return paymentMapper.toResponse(payment);
    }

    @Override
    @PreAuthorize("hasRole('ADMIN') or hasRole('HEADER')")
    public boolean delete(Long id) {

        if (!paymentRepository.existsById(id))
            throw new ResourceNotFoundException("Agreement", "id", id);
        paymentRepository.deleteById(id);
        return true;
    }

    private PageResponse<PaymentResponse> buildPageResponse(Page<Payment> result) {

        return PageResponse.<PaymentResponse>builder()
                .content(paymentMapper.toResponseList(result.getContent()))
                .page(result.getNumber())
                .pageSize(result.getSize())
                .size(result.getTotalElements())
                .totalPages(result.getTotalPages())
                .last(result.isLast())
                .build();
    }
}
