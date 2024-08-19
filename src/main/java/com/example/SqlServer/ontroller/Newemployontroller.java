package com.example.SqlServer.ontroller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	
	//build get all newemployee rest api
	
	@GetMapping("/getnewemployee")
	public List<NewEmployee>  getallNewemployee()  {
		
		return newemployservie.getallNewEmployees();
		
		
		
	}
	
	
	//build get newemployee by id rest api
	
	@GetMapping("/getnewemployee/{id}")
	public ResponseEntity<NewEmployee> getbyid(@PathVariable("id") long employeeid)  {
		
		return new ResponseEntity<NewEmployee>(newemployservie.getemployeebyID(employeeid), HttpStatus.OK);
	}
	
	
	//build update newemployee by id rest api
	
	@PutMapping("/getnewemployies/{id}")
	public ResponseEntity<NewEmployee> updateemployee(
			                                          @PathVariable("id") long id,
			                                          @RequestBody NewEmployee updateemployee)  {
		
		
		return new ResponseEntity<NewEmployee>(newemployservie.updatenewemployee(updateemployee, id), HttpStatus.OK);
		
		
	}
	
	
	
	//build delete employee rest api
	
	@DeleteMapping("/deletenewemployies/{id}")
	public ResponseEntity<String> deleteemployee(@PathVariable("id") long id)  {
		
		newemployservie.deleteemployee(id);
		
		return new ResponseEntity<String>("Employee Deleted Suessfully", HttpStatus.OK);
		
	}
	

}
