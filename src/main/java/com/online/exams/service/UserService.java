package com.online.exams.service;

import com.online.exams.entity.User;
import com.online.exams.request.UserRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface UserService {

    void add(UserRequest request);

    List<User> findAll();

    Page<User> findAllPage(int page, int size);

    User findById(String id);

    void update(UserRequest request, String id);

    void delete(String id);

}
