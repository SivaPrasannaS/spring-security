package com.learn.springsecurity.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.learn.springsecurity.dto.response.BasicResponse;
import com.learn.springsecurity.dto.response.UserResponse;
import com.learn.springsecurity.model.Users;
import com.learn.springsecurity.repository.UsersRepository;
import com.learn.springsecurity.service.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UsersRepository usersRepository;

    @Override
    public BasicResponse<UserResponse> getAllUser() {
        List<Users> users = usersRepository.findAll();
        List<UserResponse> userResponse = users.stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .password(user.getPassword())
                        .role(user.getRole())
                        .image(user.getImage())
                        .address(user.getAddress())
                        .build())
                .collect(Collectors.toList());
        return BasicResponse.<UserResponse>builder().message("User data fetched successfully!").data(userResponse)
                .build();
    }
}
