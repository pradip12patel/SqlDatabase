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
       
       System.out.println("-----------------------------------------------------");
		
		return new ResponseEntity<NewEmployee>(newemployservie.saveemployee(newemployee), HttpStatus.CREATED);
		
		  
	}
	
	
	@CrossOrigin(origins = "*")
	@PostMapping("/group")
	public ResponseEntity<NewEmployee> saveemployees(@RequestBody  NewEmployee[] newemployees){
		
	  System.out.println("Array_Send_Value: " + (newemployees).length );
	  
	   // Print each employee details
      for (NewEmployee emp : newemployees) {
          System.out.println("Name: " + emp.getEmployee_name());
          System.out.println("Email: " + emp.getEmail());
          System.out.println("Mother: " + emp.getEmployee_mothername());
          System.out.println("Father: " + emp.getEmployee_fathername());
          System.out.println("Salary: " + emp.getSalary());
          System.out.println("-----------------------------------------------------");
      }
	 
    
		return new ResponseEntity(newemployservie.savesEmployees(newemployees), HttpStatus.CREATED);
		
		  
	}         
	
	
	//build get all newemployee rest api
	
	@GetMapping("/getnewemployee")
	public List<NewEmployee>  getallNewemployee()  {
		
		 // Print message when fetching employees
        System.out.println("Fetching all employees.....");
		
		return newemployservie.getallNewEmployees();
		
	}
	
	
	//build get newemployee by id rest api
	
	@GetMapping("/getnewemployee/{id}")
	public ResponseEntity<NewEmployee> getbyid(@PathVariable("id") long employeeid)  {
		
		 // Print the ID of the employee being fetched
        System.out.println("Fetching employee with ID: " + employeeid);
		
		return new ResponseEntity<NewEmployee>(newemployservie.getemployeebyID(employeeid), HttpStatus.OK);
	}
	
	
	//build update newemployee by id rest api
	
	@PutMapping("/getnewemployies/{id}")
	public ResponseEntity<NewEmployee> updateemployee(
			                                          @PathVariable("id") long id,
			                                          @RequestBody NewEmployee updateemployee)  {
		
		
	// Print ID and new details of the employee being updated
        System.out.println("Updating employee with ID: " + id);
        System.out.println("Updated Name: " + updateemployee.getEmployee_name());
        System.out.println("Updated Email: " + updateemployee.getEmail());
        System.out.println("Updated Mother: " + updateemployee.getEmployee_mothername());
        System.out.println("Updated Father: " + updateemployee.getEmployee_fathername());
        System.out.println("Updated Salary: " + updateemployee.getSalary());
		
		return new ResponseEntity<NewEmployee>(newemployservie.updatenewemployee(updateemployee, id), HttpStatus.OK);
		
		
	}
	
	
	
	//build delete employee rest api
	
	@DeleteMapping("/deletenewemployies/{id}")
	public ResponseEntity<String> deleteemployee(@PathVariable("id") long id)  {
		
		// Print ID of the employee being deleted
        System.out.println("Deleting employee with ID: " + id);

        newemployservie.deleteemployee(id);

        return new ResponseEntity<String>("Employee Deleted Successfully", HttpStatus.OK);
		
	}
	

}
