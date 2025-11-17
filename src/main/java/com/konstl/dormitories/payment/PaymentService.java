package com.konstl.dormitories.payment;

import com.konstl.dormitories.payment.dto.CreatePaymentRequest;
import com.konstl.dormitories.payment.dto.PaymentResponse;
import com.konstl.dormitories.payment.dto.PaymentSearchDto;
import com.konstl.dormitories.payment.dto.UpdatePaymentRequest;
import com.konstl.dormitories.utils.PageResponse;

public interface PaymentService {

    PaymentResponse findById(Long id);

    PageResponse<PaymentResponse> findAll(int page, int size);

    PageResponse<PaymentResponse> search(PaymentSearchDto searchDto, int page, int size);

    PaymentResponse create(CreatePaymentRequest createRequest);

    PaymentResponse update(Long id, UpdatePaymentRequest updateRequest);

    boolean delete(Long id);
}
