package com.example.sts.web.dto;

import com.example.sts.model.User;

import lombok.Data;

@Data
public class UserRegistrationDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public UserRegistrationDto() {

    }

    public UserRegistrationDto(User user) {
        super();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.email = user.getEmail();
        this.password = user.getPassword();
    }
}
