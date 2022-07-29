package com.online.exams.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@SuperBuilder
@EntityListeners(AuditingEntityListener.class)
public class BaseEntity implements Serializable {

        @Id
        @GeneratedValue(generator = "system-uuid")
        @GenericGenerator(name = "system-uuid", strategy = "uuid2")
        @Column(columnDefinition = "varchar(36)")
        private String id;

        @CreatedDate
        @Column(updatable = false,nullable = false)
        private LocalDateTime createdDate;

        @LastModifiedDate
        @Column(nullable = false)
        private LocalDateTime modifiedDate;

        @CreatedBy
        @Column(nullable = false, updatable = false)
        private String createdBy;

        @LastModifiedBy
        private String updatedBy;
}
