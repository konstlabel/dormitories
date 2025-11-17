package com.konstl.dormitories.position;

import com.konstl.dormitories.position.dto.CreatePositionRequest;
import com.konstl.dormitories.position.dto.PositionResponse;
import com.konstl.dormitories.position.dto.UpdatePositionRequest;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface PositionMapper {

    PositionMapper INSTANCE = Mappers.getMapper(PositionMapper.class);

    PositionResponse toResponse(Position Position);

    Position toEntity(CreatePositionRequest createRequest);

    void updateEntityFromRequest(UpdatePositionRequest updateRequest, @MappingTarget Position Position);

    List<PositionResponse> toResponseList(List<Position> positions);
}