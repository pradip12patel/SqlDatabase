package com.example.SqlServer.serviceImpl;


import com.example.SqlServer.reposotry.signinreposotory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private signinreposotory userRepository;

    // Method to check if the email exists in the database
    public boolean emailExists(String email) {
        // Use the repository to find a user by email
        return userRepository.findByEmail(email).isPresent();
    }

    // Method to send reset password email
    public void sendResetPasswordEmail(String email) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setFrom("info@anaya.in");
        message.setSubject("Reset Password Request");
        message.setText("Click the link below to reset your password:\nhttp://localhost:8082/reset?email=" + email);
        mailSender.send(message);
    }
}

