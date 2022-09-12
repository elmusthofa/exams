package com.online.exams.mapper;

import com.online.exams.dto.RoomClassDto;
import com.online.exams.entity.RoomClass;
import com.online.exams.request.RoomClassRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class RoomClassMapper implements BaseMapper<RoomClass, RoomClassDto>{

    @Override
    public RoomClass toEntity(RoomClassDto dto) {
        return null;
    }

    @Override
    public RoomClassDto toDto(RoomClass entity) {
        return RoomClassDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .build();
    }

    @Override
    public List<RoomClass> toEntities(List<RoomClassDto> dtos) {
        return null;
    }

    @Override
    public List<RoomClassDto> toDtos(List<RoomClass> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public RoomClass fromRequest(RoomClassRequest request) {
        return RoomClass.builder()
                .name(request.getName())
                .build();
    }
}
