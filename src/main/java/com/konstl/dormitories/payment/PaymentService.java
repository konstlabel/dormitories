package com.konstl.dormitories.payment;

import com.konstl.dormitories.payment.dto.CreatePaymentRequest;
import com.konstl.dormitories.payment.dto.PaymentResponse;
import com.konstl.dormitories.payment.dto.UpdatePaymentRequest;
import com.konstl.dormitories.resident.Resident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.sql.Timestamp;

public interface PaymentService {

    PaymentResponse findById(Long id);

    Page<PaymentResponse> findByDate(Timestamp date, Pageable pageable);

    Page<PaymentResponse> findByAmount(Double amount, Pageable pageable);

    Page<PaymentResponse> findByPeriod(Integer period, Pageable pageable);

    Page<PaymentResponse> findByResident(Resident resident, Pageable pageable);

    Page<PaymentResponse> findByResidentAndPeriod(Resident resident, Integer period, Pageable pageable);

    PaymentResponse create(CreatePaymentRequest createRequest);

    PaymentResponse update(UpdatePaymentRequest updateRequest);

    PaymentResponse delete(Long id);
}
