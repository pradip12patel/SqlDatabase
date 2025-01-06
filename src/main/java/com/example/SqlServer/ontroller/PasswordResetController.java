package com.example.SqlServer.ontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SqlServer.model.User;
import com.example.SqlServer.serviceImpl.EmailService;

@RestController
@RequestMapping("/api")
public class PasswordResetController {

    @Autowired
    private EmailService emailService;

    @CrossOrigin(origins = "http://localhost:8083")
    @PostMapping("/forgetpassword")
    public ResponseEntity<?> forgotPassword(@RequestBody User emailRequest) {
        String email = emailRequest.getEmail();

        if (emailService.emailExists(email)) {
            emailService.sendResetPasswordEmail(email);
            return ResponseEntity.ok().body(new ApiResponse(true, "A reset password email has been sent to your email address."));
        } else {
            return ResponseEntity.status(HttpStatusCode.valueOf(404)).body(new ApiResponse(false, "Email not found. Please check and try again."));
        }
    }
    
    
 // ApiResponse.java
    public class ApiResponse {
        private boolean success;
        private String message;

        public ApiResponse(boolean success, String message) {
            this.success = success;
            this.message = message;
        }

        // Getters and Setters
        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
        
    }

    
    
 // ApiResponse.java
    public class ApiResponse1 {
       
        private String message;

        public ApiResponse1(String message) {
            this.message = message;
        }

        
        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    
    }
}

