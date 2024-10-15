package com.example.SqlServer.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SqlServer.serviceImpl.EmailService;

import jakarta.mail.MessagingException;

@RestController
@RequestMapping("/api/email")
public class ContactController {

//    private final com.example.SqlServer.serviceImpl.EmailService emailService;
//
//    public ContactController(EmailService emailService) {
//        this.emailService = emailService;
//    }
//
//    @PostMapping("/send")
//    public ResponseEntity<String> sendEmail(
//            @RequestParam String to,
//            @RequestParam String subject,
//            @RequestParam String text) {
//        try {
//            emailService.sendSimpleEmail(to, subject, text);
//            return ResponseEntity.ok("Email sent successfully");
//        } catch (Exception e) {
//            return ResponseEntity.internalServerError()
//                .body("Failed to send email: " + e.getMessage());
//        }
//    }
//
//    @PostMapping("/send-html")
//    public ResponseEntity<String> sendHtmlEmail(
//            @RequestParam String to,
//            @RequestParam String subject,
//            @RequestParam String htmlContent) {
//        try {
//            emailService.sendHtmlEmail(to, subject, htmlContent);
//            return ResponseEntity.ok("HTML email sent successfully");
//        } catch (MessagingException e) {
//            return ResponseEntity.internalServerError()
//                .body("Failed to send HTML email: " + e.getMessage());
//        }
//    }
}