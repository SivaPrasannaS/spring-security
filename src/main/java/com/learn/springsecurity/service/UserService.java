package com.learn.springsecurity.service;

import com.learn.springsecurity.dto.response.BasicResponse;
import com.learn.springsecurity.dto.response.UserResponse;

public interface UserService {

    BasicResponse<UserResponse> getAllUser();

}
