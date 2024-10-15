package com.example.SqlServer.servie;

import java.util.List;

import com.example.SqlServer.model.User;

public interface NewemployeeServie {

	User saveuser(User newemployee);
	
    User postuser(User newemployees);
	
	List<User>  getalluser();
	
	User getuserbyID(long id);
	
	User updateuser(User employee, long id);
	
	void deleteuser(long id);

	

	

 

	
	
}
