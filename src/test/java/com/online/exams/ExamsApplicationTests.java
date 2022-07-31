package com.online.exams;

import com.online.exams.entity.Role;
import com.online.exams.entity.User;
import com.online.exams.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ExamsApplication.class)
class ExamsApplicationTests {

    @Autowired
    public UserRepository userRepository;

    @Test
    void contextLoads() {

    }

    @Test
    public void insertTest() {
        userRepository.save(User.builder()
                .createdBy("admin")
                .createdDate(LocalDateTime.now())
                .updatedBy("admin")
                .modifiedDate(LocalDateTime.now())
                .email("test@gmail.com")
                .hp("089887809812")
                .namaLengkap("Test Mantap")
                .password(BCrypt.hashpw("urip", BCrypt.gensalt(12)))
                .role(Role.SUPER_ADMIN)
                .username("sabil")
                .build());
    }

}
