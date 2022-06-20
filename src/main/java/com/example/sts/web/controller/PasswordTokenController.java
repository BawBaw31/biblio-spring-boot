package com.example.sts.web.controller;

import java.util.Locale;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.sts.model.User;
import com.example.sts.repository.UserRepository;
import com.example.sts.service.PasswordTokenService;
import com.example.sts.service.UserService;
import com.example.sts.web.dto.PasswordDto;

@Controller
public class PasswordTokenController {
    @Autowired
    private PasswordTokenService passwordTokenService;
    
    @Autowired
    private JavaMailSenderImpl mailSender;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("/user/changePassword")
    public String showChangePasswordPage(Locale locale, Model model, 
    @RequestParam("token") String token) {
        String result = passwordTokenService.validatePasswordResetToken(token);
        if(result != null) {
            return "redirect:/login?error";
        } else {
            return "redirect:/updatePassword?token=" + token;
        }
    }

    @PostMapping("/user/resetPassword")
    public String resetPassword(HttpServletRequest request, 
        @ModelAttribute("email") String userEmail) {
        User user = userRepository.findByEmail(userEmail);
        if (user == null) {
            return "redirect:/forgotPassword?error";
        }
        String token = UUID.randomUUID().toString();
        passwordTokenService.createPasswordResetTokenForUser(user, token);
        mailSender.send(constructResetTokenEmail(
            request.getRequestURL().toString().replace(request.getServletPath(), ""), 
            token, user));
        return "redirect:/forgotPassword?success";
    }

    @PostMapping("/user/savePassword")
    public String savePassword(final Locale locale, @Validated PasswordDto passwordDto) {

        String result = passwordTokenService.validatePasswordResetToken(passwordDto.getToken());

        if(result != null) {
            return "redirect:/updatePassword?error=true?&token=" + passwordDto.getToken();
        }

        User user = userService.findUserByPasswordResetToken(passwordDto.getToken());
        if(user != null && passwordDto.getConfirmPassword().equals(passwordDto.getNewPassword())) {
            userService.changeUserPassword(user, passwordDto.getNewPassword());
            return "redirect:/updatePassword?success=true?&token=" + passwordDto.getToken();
        } else {
            return "redirect:/updatePassword?error=true?&token=" + passwordDto.getToken();
        }
    }

    private SimpleMailMessage constructResetTokenEmail(
    String contextPath, String token, User user) {
        String url = contextPath + "/user/changePassword?token=" + token;
        String message = "Reset your password by clicking the link: " + url;
        return constructEmail("Reset Password", message, user);
    }

    private SimpleMailMessage constructEmail(String subject, String body, 
    User user) {
        SimpleMailMessage email = new SimpleMailMessage();
        email.setSubject(subject);
        email.setText(body);
        email.setTo(user.getEmail());
        // email.setFrom(env.getProperty("support.email"));
        return email;
    }
}
