package com.example.sts.service;

import java.util.Calendar;

import com.example.sts.model.PasswordResetToken;
import com.example.sts.model.User;
import com.example.sts.repository.PasswordTokenRepository;

public class PasswordTokenService {
    private PasswordTokenRepository passwordTokenRepository;

    public void createPasswordResetTokenForUser(User user, String token) {
        PasswordResetToken myToken = new PasswordResetToken(token, user);
        passwordTokenRepository.save(myToken);
    }

    public String validatePasswordResetToken(String token) {
        final PasswordResetToken passToken = passwordTokenRepository.findByToken(token);
    
        return !isTokenFound(passToken) ? "invalidToken"
                : isTokenExpired(passToken) ? "expired"
                : null;
    }
    
    private boolean isTokenFound(PasswordResetToken passToken) {
        return passToken != null;
    }
    
    private boolean isTokenExpired(PasswordResetToken passToken) {
        final Calendar cal = Calendar.getInstance();
        return passToken.getExpiryDate().before(cal.getTime());
    }
}
