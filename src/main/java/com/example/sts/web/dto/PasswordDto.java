package com.example.sts.web.dto;

import lombok.Data;

@Data
public class PasswordDto {

    private String newPassword;

    private String confirmPassword;

    private  String token;

}