package com.online.exams.repository;

import com.online.exams.entity.User;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, String>, JpaSpecificationExecutor<User> {

    User findByUsernameOrEmail(String username, String email);

//    Page<User> findAll(Pageable pageable);
}
