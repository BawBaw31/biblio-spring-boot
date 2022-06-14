package com.example.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sts.model.PasswordResetToken;

public interface PasswordTokenRepository extends JpaRepository<PasswordResetToken, Long> {
    PasswordResetToken findByToken(String token);
}
