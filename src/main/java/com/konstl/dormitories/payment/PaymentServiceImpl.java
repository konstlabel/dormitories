package com.konstl.dormitories.payment;

import com.konstl.dormitories.payment.dto.CreatePaymentRequest;
import com.konstl.dormitories.payment.dto.PaymentResponse;
import com.konstl.dormitories.payment.dto.UpdatePaymentRequest;
import com.konstl.dormitories.resident.Resident;
import com.konstl.dormitories.resident.ResidentRepository;
import com.konstl.dormitories.utils.PageResponse;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
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
    public PageResponse<PaymentResponse> findByDate(Timestamp date, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<PaymentResponse> findByAmount(BigDecimal amount, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<PaymentResponse> findByPeriod(Integer period, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<PaymentResponse> findByResidentId(Long residentId, int page, int size) {
        return null;
    }

    @Override
    public PageResponse<PaymentResponse> findByResidentIdAndPeriod(Long residentId, Integer period, int page, int size) {
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
