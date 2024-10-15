package com.example.SqlServer.eeption;




public class UserAlreadyExistsException extends RuntimeException{
	
	
	 public UserAlreadyExistsException(String message) {
	        super(message);
	    }

}
