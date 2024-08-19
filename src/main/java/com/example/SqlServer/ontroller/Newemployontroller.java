package com.example.SqlServer.ontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SqlServer.model.NewEmployee;
import com.example.SqlServer.servie.NewemployeeServie;

@RestController
@RequestMapping("/api")
public class Newemployontroller {
	
	
	private NewemployeeServie newemployservie;

	public Newemployontroller(NewemployeeServie newemployservie) {
		super();
		this.newemployservie = newemployservie;
	} 

	
	//build reate newemployee restapi
	
	@CrossOrigin(origins = "*")
	@PostMapping("/newemployee")
	public ResponseEntity<NewEmployee> saveEmployee(@RequestBody  NewEmployee newemployee){
		
		System.out.println("Name: " + newemployee.getEmployee_name() );
       System.out.println("Email: " + newemployee.getEmail());
       System.out.println("mother: " + newemployee.getEmployee_mothername());
       System.out.println("father: " + newemployee.getEmployee_fathername());
       System.out.println("salary: " + newemployee.getSalary());
		
		return new ResponseEntity<NewEmployee>(newemployservie.saveemployee(newemployee), HttpStatus.CREATED);
		
		
		  
	}
	

}
