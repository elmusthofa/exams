package com.online.exams.config;

import com.online.exams.dto.UserDto;
import com.online.exams.util.AppUtil;
import com.online.exams.util.SecurityUtil;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * @author muhamad.fariz
 * email : farizcb@gmail.com
 * on 26/03/2022
 */
@Slf4j
@Configuration
@EnableJpaAuditing
@RequiredArgsConstructor
public class AuditConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        return () -> {
            UserDto auditor = SecurityUtil.getAuth() != null && SecurityUtil.getAuth().getDetails() != null ?
                    SecurityUtil.getAuth().getDetails() : null;

            log.info("Auditor : {}", auditor);

            if (auditor != null) {
                return Optional.of(auditor.getUsername());
            } else {
                return Optional.of(AppUtil.SYSTEM_USER_ID);
            }
        };
    }

}
