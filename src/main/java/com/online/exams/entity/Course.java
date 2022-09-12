package com.online.exams.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "sys_course")
public class Course extends BaseEntity implements Serializable {

    @Column(nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_room_class")
    private RoomClass roomClass;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private User user;
}
