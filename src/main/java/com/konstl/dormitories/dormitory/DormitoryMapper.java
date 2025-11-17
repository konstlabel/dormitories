package com.konstl.dormitories.dormitory;

import com.konstl.dormitories.dormitory.dto.CreateDormitoryRequest;
import com.konstl.dormitories.dormitory.dto.DormitoryResponse;
import com.konstl.dormitories.dormitory.dto.UpdateDormitoryRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface DormitoryMapper {

    DormitoryMapper INSTANCE = Mappers.getMapper(DormitoryMapper.class);

    DormitoryResponse toResponse(Dormitory dormitory);

    Dormitory toEntity(CreateDormitoryRequest createRequest);

    void updateEntityFromRequest(UpdateDormitoryRequest updateRequest, @MappingTarget Dormitory dormitory);

    List<DormitoryResponse> toResponseList(List<Dormitory> dormitories);
}
