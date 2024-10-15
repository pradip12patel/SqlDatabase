package com.example.SqlServer.ontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//
import com.example.SqlServer.model.LoginRequest; 
import com.example.SqlServer.model.User;
import com.example.SqlServer.seriveImpl.AuthService;

@CrossOrigin(origins = "http://localhost:8083")
@RequestMapping("/api/auth")
@RestController
public class Sign_inontroller {
	
	
	 @Autowired
	    private AuthService authService;
	   
	    @PostMapping("/signin")
	    public ResponseEntity<?> authenticateUser(@RequestBody LoginRequest loginRequest) {
	        try { 
	           
	            User user = authService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());
	            
	            return ResponseEntity.ok(new ApiResponses(true, "Sign-in successful!"));
	        } catch (Exception e) {
	        	
	            return ResponseEntity.internalServerError().body(new ApiResponses(false, e.getMessage()));
	        }
	    }
	    
	    
	    
	    
	    
	    
	    

public class ApiResponses {
    private boolean success;
    private String message;

    // Constructor, getters, and setters
    public ApiResponses(boolean success, String message) {
    	
        this.success = success;
        this.message = message;
    }
    
    
    

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
	    
	    
	    
	    

}
