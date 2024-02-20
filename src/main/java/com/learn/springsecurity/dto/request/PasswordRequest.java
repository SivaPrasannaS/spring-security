package com.learn.springsecurity.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PasswordRequest {
    private String currentPassword;
    private String newPassword;
    private String confirmationPassword;
}
