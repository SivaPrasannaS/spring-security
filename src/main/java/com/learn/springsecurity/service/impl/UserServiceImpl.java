package com.learn.springsecurity.service.impl;

import java.security.Principal;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.learn.springsecurity.dto.request.PasswordRequest;
import com.learn.springsecurity.model.User;
import com.learn.springsecurity.repository.UserRepository;
import com.learn.springsecurity.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final PasswordEncoder passwordEncoder;
    private final UserRepository userRepository;

    @Override
    public void forgotPassword(PasswordRequest request, Principal principal) {
        var user = (User) ((UsernamePasswordAuthenticationToken) principal).getPrincipal();

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword()))
            throw new IllegalStateException("Wrong password.");

        if (!request.getNewPassword().equals(request.getConfirmationPassword()))
            throw new IllegalStateException("Password mismatch.");

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        userRepository.save(user);
    }
}
