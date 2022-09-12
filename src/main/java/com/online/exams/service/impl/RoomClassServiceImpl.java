package com.online.exams.service.impl;

import com.online.exams.entity.RoomClass;
import com.online.exams.mapper.RoomClassMapper;
import com.online.exams.repository.RoomClassRepository;
import com.online.exams.request.RoomClassRequest;
import com.online.exams.service.RoomClassService;
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
public class RoomClassServiceImpl implements RoomClassService {

    private final RoomClassRepository roomClassRepository;
    private final RoomClassMapper roomClassMapper;


    @Override
    public void add(RoomClassRequest request) {
        RoomClass entity = roomClassMapper.fromRequest(request);
        roomClassRepository.save(entity);
    }

    @Override
    public List<RoomClass> findAll() {
        return (List<RoomClass>) roomClassRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
    }

    @Override
    public Page<RoomClass> findAllPage(int page, int size) {
        Pageable pageReq = PageRequest.of(page, size);
        return roomClassRepository.findAll(pageReq);
    }

    @Override
    public RoomClass findById(String id) {
        return null;
    }

    @Override
    public void update(RoomClassRequest request, String id) {
        if (id != null) {
            Optional<RoomClass> req1 = roomClassRepository.findById(id);

            if (req1.get() != null) {
                RoomClass roomClass = roomClassMapper.fromRequest(request);

                roomClass.setId(req1.get().getId());

                roomClassRepository.save(roomClass);
            }
        }
    }

    @Override
    public void delete(String id) {
        roomClassRepository.deleteById(id);
    }
}
