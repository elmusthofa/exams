package com.online.exams.service;

import com.online.exams.entity.Course;
import com.online.exams.request.CourseRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface CourseService {

    void add(CourseRequest request);

    List<Course> findAll();

    Page<Course> findAllPage(int page, int size);

    Course findById(String id);

    void update(CourseRequest request, String id);

    void delete(String id);
}
