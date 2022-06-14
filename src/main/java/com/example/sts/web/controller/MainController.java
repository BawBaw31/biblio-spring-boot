package com.example.sts.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/forgotPassword")
    public String forgetPassword() {
        return "forgotPassword";
    }

    @GetMapping("/updatePassword")
    public String updatePassword() {
        return "updatePassword";
    }

    @GetMapping("/")
    public String home() {
        return "index";
    }

}
