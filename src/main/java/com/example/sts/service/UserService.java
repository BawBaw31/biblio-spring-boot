package com.example.sts.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.example.sts.model.User;
import com.example.sts.web.dto.UserRegistrationDto;

public interface UserService extends UserDetailsService {    
    User save(UserRegistrationDto userDto);
}
