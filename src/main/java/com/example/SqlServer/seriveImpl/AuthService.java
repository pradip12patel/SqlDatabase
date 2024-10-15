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

	 

	    public User authenticateUser(String email, String password) throws Exception {
	    	
	        Optional<User> optionalUser = userRepository.findByEmail(email);

	        if (!optionalUser.isPresent()) {
	        	
	            throw new Exception("Invalid email or password");
	        }

	        return optionalUser.get();
	    }                                       
	    
	    
	    
	    
	    
	    
	
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}


