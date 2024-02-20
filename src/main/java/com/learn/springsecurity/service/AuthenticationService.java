package com.learn.springsecurity.service;

import java.io.IOException;

import com.learn.springsecurity.dto.request.LoginRequest;
import com.learn.springsecurity.dto.request.RegisterRequest;
import com.learn.springsecurity.dto.response.LoginResponse;
import com.learn.springsecurity.dto.response.RegisterResponse;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface AuthenticationService {
    RegisterResponse register(RegisterRequest request);

    LoginResponse login(LoginRequest request);

    void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException;
}
