package com.online.exams.service;

import com.online.exams.entity.RoomClass;
import com.online.exams.request.RoomClassRequest;
import org.springframework.data.domain.Page;

import java.util.List;

public interface RoomClassService {

    void add(RoomClassRequest request);

    List<RoomClass> findAll();

    Page<RoomClass> findAllPage(int page, int size);

    RoomClass findById(String id);

    void update(RoomClassRequest request, String id);

    void delete(String id);
}
