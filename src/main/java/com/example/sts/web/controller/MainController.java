package com.example.sts.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
    public String updatePassword(Model model, @RequestParam("token") String token) {
        model.addAttribute("token", token);
        return "updatePassword";
    }

}
