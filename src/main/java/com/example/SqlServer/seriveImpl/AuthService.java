package com.example.SqlServer.seriveImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SqlServer.model.User;
import com.example.SqlServer.reposotry.signinreposotory;

@Service
public class AuthService {
	
	
	 @Autowired
	    private signinreposotory userRepository;

	 

	 public User authenticate(String email, String password) {
	        // Find the user by email and check if the password matches
	        User user = userRepository.findByEmail(email);
	        if (user != null && user.getPassword().equals(password)) {
	            return user;
	        }
	        return null; // Return null if authentication fails
	    }
	    
	    
	    
	    
	    
	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}


