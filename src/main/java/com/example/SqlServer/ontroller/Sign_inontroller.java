package com.example.SqlServer.ontroller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.SqlServer.model.User; 
import com.example.SqlServer.seriveImpl.AuthService;

@CrossOrigin(origins = "http://localhost:8083")
@RequestMapping("/api/auth")
@RestController
public class Sign_inontroller {
	
	
	 @Autowired
	    private AuthService authService;
	   
	 @PostMapping("/signin")
	    public ResponseEntity<Map<String, Object>> signIn(@RequestBody Map<String, String> loginRequest) {
	        String email = loginRequest.get("email");
	        String password = loginRequest.get("password");

	        // Authenticate the user using the UserService
	        User user = authService.authenticate(email, password);

	        Map<String, Object> response = new HashMap<>();
	        if (user != null) {
	            // If authentication is successful, return user details
	            Map<String, String> userDetails = new HashMap<>();
	            userDetails.put("name", user.getName());
	            userDetails.put("email", user.getEmail());
	            userDetails.put("phone", user.getPhone());
	            userDetails.put("address", user.getAddress());

	            response.put("success", true);
	            response.put("Userdetails", userDetails);
	            response.put("message", "Sign-in successful");
	            return ResponseEntity.ok(response);
	        } else {
	            // If authentication fails, return an error response
	            response.put("success", false);
	            response.put("message", "Invalid email or password");
	            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
	        }
	    }
	    
	    
	 
	 
	 }
	 


