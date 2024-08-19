package com.example.SqlServer.seriveImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SqlServer.eeption.ResoureNotFoundEeption;
import com.example.SqlServer.model.NewEmployee;
import com.example.SqlServer.reposotry.Newemployeereposotory;
import com.example.SqlServer.servie.NewemployeeServie;


@Service
public class NewemployeeSrevieImpl implements NewemployeeServie{
	
	private Newemployeereposotory newemployeereposotory;

	@Override
	public NewEmployee saveemployee(NewEmployee newemployee) {
		
		return newemployeereposotory.save(newemployee);
	}
	
	public NewemployeeSrevieImpl(Newemployeereposotory newemployeereposotory) {
		super();
		this.newemployeereposotory = newemployeereposotory;
	}

	@Override
	public List<NewEmployee> getallNewEmployees() {
		
		return newemployeereposotory.findAll();
	}

	@Override
	public NewEmployee getemployeebyID(long id) {
		
	Optional<NewEmployee> employee = newemployeereposotory.findById(id);
	
/*	if(employee.isPresent()) {
	
		return employee.get();
	
	}else {
		
		throw new ResoureNotFoundEeption("employee", "id", id);
	}   */
	
	
	return newemployeereposotory.findById(id).orElseThrow(() -> 
	                        new ResoureNotFoundEeption("newemployee", "id", id));
	
	}

	@Override
	public NewEmployee updatenewemployee(NewEmployee employee, long id) {
		
		//we need to hek that employee eist or not in table
		NewEmployee eistemployee  = newemployeereposotory.findById(id).orElseThrow(() -> 
		                                   new ResoureNotFoundEeption("NewEmployee", "id", id));
		
		eistemployee.setEmployee_name(employee.getEmployee_name());
		eistemployee.setEmployee_fathername(employee.getEmployee_fathername());
		eistemployee.setEmployee_mothername(employee.getEmployee_mothername());
		eistemployee.setEmail(employee.getEmail());
		eistemployee.setSalary(employee.getSalary());
		
		//save eisting employee in DB
		
		newemployeereposotory.save(eistemployee);
		
		return eistemployee;
	}

	@Override
	public void deleteemployee(long id) {
		
		//hek employee eist or not
		
		newemployeereposotory.findById(id).orElseThrow(() -> new ResoureNotFoundEeption("newEmployee", "id", id));
		
		newemployeereposotory.deleteById(id);
		
	}

	
	

}
