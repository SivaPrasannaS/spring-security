package com.learn.springsecurity.dto.response;

import com.learn.springsecurity.enumerated.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {
    private String id;
    private String name;
    private String email;
    private String password;
    private Role role;
    private String image;
    private String address;
}
