package com.konstl.dormitories.payment;

import com.konstl.dormitories.payment.dto.CreatePaymentRequest;
import com.konstl.dormitories.payment.dto.PaymentResponse;
import com.konstl.dormitories.payment.dto.UpdatePaymentRequest;
import com.konstl.dormitories.utils.PageResponse;

import java.math.BigDecimal;
import java.sql.Timestamp;

public interface PaymentService {

    PaymentResponse findById(Long id);

    PageResponse<PaymentResponse> findByDate(Timestamp date, int page, int size);

    PageResponse<PaymentResponse> findByAmount(BigDecimal amount, int page, int size);

    PageResponse<PaymentResponse> findByPeriod(Integer period, int page, int size);

    PageResponse<PaymentResponse> findByResidentId(Long residentId, int page, int size);

    PageResponse<PaymentResponse> findByResidentIdAndPeriod(Long residentId, Integer period, int page, int size);

    PaymentResponse create(CreatePaymentRequest createRequest);

    PaymentResponse update(UpdatePaymentRequest updateRequest);

    PaymentResponse delete(Long id);
}
