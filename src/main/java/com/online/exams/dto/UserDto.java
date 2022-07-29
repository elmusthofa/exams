package com.online.exams.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.online.exams.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserDto {

    private String id;
    private String username;
    private String email;
    private String password;
    private String namaLengkap;
    private String hp;
    private Role role;
    private Boolean active = false;

}
