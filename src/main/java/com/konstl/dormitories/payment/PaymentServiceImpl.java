package com.konstl.dormitories.payment;

import com.konstl.dormitories.payment.dto.CreatePaymentRequest;
import com.konstl.dormitories.payment.dto.PaymentResponse;
import com.konstl.dormitories.payment.dto.UpdatePaymentRequest;
import com.konstl.dormitories.resident.Resident;
import com.konstl.dormitories.resident.ResidentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

@Service
@Transactional(readOnly = true)
public class PaymentServiceImpl implements PaymentService {

    private static final String NO_PERM = "You don't have permission to make this operation";

    private final PaymentRepository paymentRepository;
    private final ResidentRepository residentRepository;

    public PaymentServiceImpl(PaymentRepository paymentRepository,
                              ResidentRepository residentRepository) {

        this.paymentRepository = paymentRepository;
        this.residentRepository = residentRepository;
    }

    @Override
    public PaymentResponse findById(Long id) {
        return null;
    }

    @Override
    public Page<PaymentResponse> findByDate(Timestamp date, Pageable pageable) {
        return null;
    }

    @Override
    public Page<PaymentResponse> findByAmount(Double amount, Pageable pageable) {
        return null;
    }

    @Override
    public Page<PaymentResponse> findByPeriod(Integer period, Pageable pageable) {
        return null;
    }

    @Override
    public Page<PaymentResponse> findByResident(Resident resident, Pageable pageable) {
        return null;
    }

    @Override
    public Page<PaymentResponse> findByResidentAndPeriod(Resident resident, Integer period, Pageable pageable) {
        return null;
    }

    @Override
    public PaymentResponse create(CreatePaymentRequest createRequest) {
        return null;
    }

    @Override
    public PaymentResponse update(UpdatePaymentRequest updateRequest) {
        return null;
    }

    @Override
    public PaymentResponse delete(Long id) {
        return null;
    }
}
