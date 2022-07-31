package com.online.exams.service.impl;

import com.online.exams.entity.User;
import com.online.exams.mapper.UserMapper;
import com.online.exams.repository.UserRepository;
import com.online.exams.request.UserRequest;
import com.online.exams.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void add(UserRequest request) {
        User entity = userMapper.fromRequest(request);
        userRepository.save(entity);
    }


//    @Override
//    public void save(UserReq userReq) {
//        User user = userMapper.fromReq(userReq);
//
//        userRepository.save(user);
//    }
//
//    @Override
//    public List<User> findAll() {
//        return(List<User>) userRepository.findAll(Sort.by(Sort.Direction.DESC, "id"));
//    }
//
//    @Override
//    public User findById(String id) {
//        return null;
//    }
//
//    @Override
//    public void update(UserReq userReq, String id) {
//        if (id != null) {
//            Optional<User> req1 = userRepository.findById(id);
//
//            if (req1.get() != null) {
//                User user = userMapper.fromReq(userReq);
//
//                user.setId(req1.get().getId());
//
//                userRepository.save(user);
//            }
//        }
//    }
//
//    @Override
//    public void delete(String id) {
//        userRepository.deleteById(id);
//    }
}
