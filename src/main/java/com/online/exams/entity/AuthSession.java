package com.online.exams.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.Type;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sys_auth_session")
public class AuthSession extends BaseEntity implements Serializable {

    @Lob
    @Type(type = "text")
    @Column(columnDefinition = "TEXT", nullable = false)
    private String token;

    @ManyToOne
    @JoinColumn(name = "id_user", nullable = false)
    private User user;
}
