package com.online.exams.service.impl;

import com.online.exams.entity.Course;
import com.online.exams.mapper.CourseMapper;
import com.online.exams.repository.CourseRepository;
import com.online.exams.request.CourseRequest;
import com.online.exams.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepository;
    private final CourseMapper courseMapper;

    @Override
    public void add(CourseRequest request) {
        Course entity = courseMapper.fromRequest(request);
        courseRepository.save(entity);
    }

    @Override
    public List<Course> findAll() {
        return (List<Course>) courseRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<Course> findAllPage(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return courseRepository.findAll(pageable);
    }

    @Override
    public Course findById(String id) {
        return null;
    }

    @Override
    public void update(CourseRequest request, String id) {
        if (id != null) {
            Optional<Course> req1 = courseRepository.findById(id);

            if (req1.get() != null) {
                Course course = courseMapper.fromRequest(request);

                course.setId(req1.get().getId());

                courseRepository.save(course);
            }
        }
    }

    @Override
    public void delete(String id) {
        courseRepository.deleteById(id);
    }
}
