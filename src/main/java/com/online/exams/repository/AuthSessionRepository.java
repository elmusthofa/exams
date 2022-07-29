package com.online.exams.repository;

import com.online.exams.entity.AuthSession;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AuthSessionRepository extends JpaRepository<AuthSession, String>, JpaSpecificationExecutor<AuthSession> {

    Optional<AuthSession> findByToken(String token);

    List<AuthSession> findByUserId(String idUser);
}
