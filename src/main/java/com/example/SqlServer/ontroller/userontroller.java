package com.example.SqlServer.ontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SqlServer.model.User;
import com.example.SqlServer.seriveImpl.userservie;

@RestController
@RequestMapping("/api/auth")
public class userontroller {
	
	@Autowired
	private userservie signupService;
	
//	  @Autowired
//	    private Userreposotory userRepository;
	
	
	@CrossOrigin(origins = "http://localhost:8083")
	 @PostMapping("/signup")
	    public ResponseEntity<ApiResponse> signup(@RequestBody User signupRequest) {
		
       String response = signupService.registerUser(signupRequest);
       if (response.equals("User registered successfully!")) {
    	   
         return ResponseEntity.ok(new ApiResponse(true, response));
	        } else {
	        	
            return ResponseEntity.badRequest().body(new ApiResponse(false, response));
        
	        }

        

   /*    @PostMapping("/signup")
       public ResponseEntity<String> registerUser(@RequestBody User user) {
           // Check if the email already exists
           if (userRepository.existsByEmail(user.getEmail())) {
               return ResponseEntity
                   .status(HttpStatus.BAD_REQUEST)
                   .body("Error: Email is already in use!");
           }

           // Save the user (password should ideally be hashed)
           userRepository.save(user);

           return ResponseEntity.ok("User registered successfully!");
       }
		*/
		

    }

	





public class ApiResponse {
	
    private boolean success;
    private String message;

    // Constructor, getters, and setters
    public ApiResponse(boolean success, String message) {
    	
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














     