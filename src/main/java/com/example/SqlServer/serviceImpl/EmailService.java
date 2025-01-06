package com.example.SqlServer.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.example.SqlServer.reposotry.signinreposotory;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private signinreposotory userRepository;

    // Method to check if the email exists in the database
    public boolean emailExists(String email) {
        // Use the repository to find a user by email
        return userRepository.findByemail(email).isPresent();
    }

    // Method to send reset password email with a clickable hyperlink
    public void sendResetPasswordEmail(String email) {
        // Generate the reset link
        String resetLink = "http://localhost:8082/reset?email=" + email;

        try {
            // Create a MimeMessage
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);

            // Set email properties
            helper.setTo(email);
            helper.setFrom("info@anaya.in");
            helper.setSubject("Reset Password Request");

            // Set email content with HTML to make the link clickable
            String htmlContent = "<p>Click the link below to reset your password:</p>"
                                + "<p><a href=\"" + resetLink + "\">Reset Password</a></p>";

            helper.setText(htmlContent, true); // true indicates HTML content

            // Send the email
            mailSender.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
            // Handle exception, e.g., log error or notify an admin
        }
    }
}
