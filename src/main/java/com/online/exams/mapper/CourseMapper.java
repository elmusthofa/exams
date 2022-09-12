package com.online.exams.mapper;

import com.online.exams.dto.CourseDto;
import com.online.exams.entity.Course;
import com.online.exams.request.CourseRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class CourseMapper implements BaseMapper<Course, CourseDto>{

    @Override
    public Course toEntity(CourseDto dto) {
        return null;
    }

    @Override
    public CourseDto toDto(Course entity) {
        return CourseDto.builder()
                .id(entity.getId())
                .name(entity.getName())
                .roomClass(entity.getRoomClass())
                .user(entity.getUser())
                .build();
    }

    @Override
    public List<Course> toEntities(List<CourseDto> dtos) {
        return null;
    }

    @Override
    public List<CourseDto> toDtos(List<Course> entities) {
        return entities.stream().map(this::toDto).collect(Collectors.toList());
    }

    public Course fromRequest(CourseRequest request) {
        return Course.builder()
                .name(request.getName())
                .roomClass(request.getRoomClass())
                .user(request.getUser())
                .build();
    }
}
