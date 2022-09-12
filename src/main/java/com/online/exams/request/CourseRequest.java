package com.online.exams.request;

import com.online.exams.entity.RoomClass;
import com.online.exams.entity.User;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CourseRequest {

    private String name;
    private String roomClass;
    private String user;
}
