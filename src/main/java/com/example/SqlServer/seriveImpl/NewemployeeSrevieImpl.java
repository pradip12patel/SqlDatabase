package com.example.SqlServer.seriveImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.SqlServer.eeption.ResourceNotFoundException;
import com.example.SqlServer.model.User;
import com.example.SqlServer.reposotry.Userreposotory;
import com.example.SqlServer.servie.NewemployeeServie;


@Service
public class NewemployeeSrevieImpl implements NewemployeeServie{
	
	private Userreposotory userreposotory;
	
	
      public NewemployeeSrevieImpl(Userreposotory userreposotory) {
		
		super();
		this.userreposotory = userreposotory;
	}

	
	
	
	
	
	

	@Override
	public User saveuser(User user) {
		
		return userreposotory.save(user);
	}
	
	
	@Override
	public List<User> getalluser() {
		
		return userreposotory.findAll();
	}

	@Override
	public User getuserbyID(long id) {
		
	Optional<User> user = userreposotory.findById(id);
	
/*	if(employee.isPresent()) {
	
		return employee.get();
	
	}else {
		
		throw new ResoureNotFoundEeption("employee", "id", id);
	}   */
	
	
	return userreposotory.findById(id).orElseThrow(() -> 
	                        new ResourceNotFoundException("user", "id", id));
	
	}

	@Override
	public User updateuser(User user, long id) {
		
		//we need to hek that employee eist or not in table
		User eistuser = userreposotory.findById(id).orElseThrow(() -> 
		                                   new ResourceNotFoundException("user", "id", id));
		
//		eistemployee.setEmployee_name(employee.getEmployee_name());
//		eistemployee.setEmployee_fathername(employee.getEmployee_fathername());
//		eistemployee.setEmployee_mothername(employee.getEmployee_mothername());
//		eistemployee.setEmail(employee.getEmail());
//		eistemployee.setSalary(employee.getSalary());
		
		//save eisting employee in DB
		
		userreposotory.save(eistuser);
		
		return eistuser;
	}

	

	 

	@Override
	public User postuser(User newemployees) {
		
		
		return null;
	}




	@Override
	public void deleteuser(long id) {
		
		userreposotory.findById(id).orElseThrow(() -> new ResourceNotFoundException("newEmployee", "id", id));
		
	    userreposotory.deleteById(id);
		
	}

	
	                          
	
	
	

}
