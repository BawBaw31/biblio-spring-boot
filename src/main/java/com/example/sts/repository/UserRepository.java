package com.example.sts.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.sts.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
