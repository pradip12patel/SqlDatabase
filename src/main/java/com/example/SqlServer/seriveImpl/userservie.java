package com.example.SqlServer.seriveImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SqlServer.model.User;
import com.example.SqlServer.reposotry.Userreposotory;

@Service
public class userservie {
	
          @Autowired
	    private Userreposotory userRepository;

   
	

	    public String registerUser(User signupRequest) {
	        // Check if email already exists
	        if (userRepository.existsByEmail(signupRequest.getEmail())) {
	        	
	            return "Email already in use!";
	        }

	        // Create new user and encode password
	        User user = new User();
	        user.setAddress(signupRequest.getAddress());
	        user.setName(signupRequest.getName());
	        user.setEmail(signupRequest.getEmail());
	        user.setDob(signupRequest.getDob());
	        user.setId(signupRequest.getId());
	        user.setPassword(signupRequest.getPassword());
	        user.setPhone(signupRequest.getPhone());

	        // Save user to the database
	        userRepository.save(user);

	        return "User registered successfully!";
	    }


    
	    
	   


}
