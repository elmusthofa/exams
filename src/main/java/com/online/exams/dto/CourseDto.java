package com.online.exams.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.online.exams.entity.RoomClass;
import com.online.exams.entity.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class CourseDto {

    private String id;
    private String name;
    private String roomClass;
    private String user;

}
