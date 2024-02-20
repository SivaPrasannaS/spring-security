package com.learn.springsecurity.service;

import java.security.Principal;

import com.learn.springsecurity.dto.request.PasswordRequest;

public interface UserService {

    void forgotPassword(PasswordRequest request, Principal principal);

}
