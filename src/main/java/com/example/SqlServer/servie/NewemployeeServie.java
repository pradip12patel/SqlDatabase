package com.example.SqlServer.servie;

import java.util.List;

import com.example.SqlServer.model.NewEmployee;

public interface NewemployeeServie {

	NewEmployee saveemployee(NewEmployee newemployee);
	
	List<NewEmployee>  getallNewEmployees();
	
	NewEmployee getemployeebyID(long id);
	
	NewEmployee updatenewemployee(NewEmployee employee, long id);
	
	void deleteemployee(long id);
	
}
