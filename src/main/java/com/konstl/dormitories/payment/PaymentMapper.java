package com.konstl.dormitories.payment;

import com.konstl.dormitories.payment.dto.CreatePaymentRequest;
import com.konstl.dormitories.payment.dto.PaymentResponse;
import com.konstl.dormitories.payment.dto.UpdatePaymentRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PaymentMapper {

    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);

    PaymentResponse toResponse(Payment payment);

    Payment toEntity(CreatePaymentRequest createRequest);

    void updateEntityFromRequest(UpdatePaymentRequest updateRequest, @MappingTarget Payment payment);

    List<PaymentResponse> toResponseList(List<Payment> dormitories);
}
