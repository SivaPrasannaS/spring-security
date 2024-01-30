package com.learn.springsecurity.service;

import com.learn.springsecurity.dto.request.LoginRequest;
import com.learn.springsecurity.dto.request.RegisterRequest;
import com.learn.springsecurity.dto.response.LoginResponse;
import com.learn.springsecurity.dto.response.RegisterResponse;

public interface AuthenticationService {
    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}
