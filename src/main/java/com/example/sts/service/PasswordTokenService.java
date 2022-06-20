package com.example.sts.service;

import com.example.sts.model.User;

public interface PasswordTokenService {
    void createPasswordResetTokenForUser(User user, String token);
    String validatePasswordResetToken(String token);
}
