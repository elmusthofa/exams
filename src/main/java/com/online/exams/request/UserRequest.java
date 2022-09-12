package com.online.exams.request;

import com.online.exams.entity.Role;
import com.online.exams.entity.RoomClass;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRequest {

    private String username;
    private String email;
    private String password;
    private String namaLengkap;
    private String hp;
    private Role role;
    private Boolean active;
    private RoomClass roomClass;
}
