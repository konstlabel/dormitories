package com.konstl.dormitories.agreement;

import com.konstl.dormitories.agreement.dto.AgreementResponse;
import com.konstl.dormitories.agreement.dto.CreateAgreementRequest;
import com.konstl.dormitories.agreement.dto.UpdateAgreementRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface AgreementMapper {

    AgreementMapper INSTANCE = Mappers.getMapper(AgreementMapper.class);

    AgreementResponse toResponse(Agreement agreement);

    Agreement toEntity(CreateAgreementRequest createRequest);

    void updateEntityFromRequest(UpdateAgreementRequest updateRequest, @MappingTarget Agreement agreement);

    List<AgreementResponse> toResponseList(List<Agreement> agreements);
}
