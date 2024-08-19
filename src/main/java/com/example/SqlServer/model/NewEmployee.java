package com.example.SqlServer.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "NewEmployeeTabel")
public class NewEmployee {
	
	/*
	public NewEmployee(int id, String employee_name, String employee_fathername, String employee_mothername,
			String email, long salary) {
		super();
		this.id = id;
		this.employee_name = employee_name;
		this.employee_fathername = employee_fathername;
		this.employee_mothername = employee_mothername;
		this.email = email;
		this.salary = salary;
	}   */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "Name", nullable = false)
	private String employee_name;
	
	@Column(name = "father_name", nullable = false)
	private String employee_fathername;
	
	@Column(name = "mother_name", nullable = false)
	private String employee_mothername;
	
	@Column(name = "Email")
	private String email;   
	
	@Column(name = "salary", nullable = false)
	private int salary;

	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmployee_name() {
		return employee_name;
	}

	public void setEmployee_name(String employee_name) {
		this.employee_name = employee_name;
	}

	public String getEmployee_fathername() {
		return employee_fathername;
	}

	public void setEmployee_fathername(String employee_fathername) {
		this.employee_fathername = employee_fathername;
	}

	public String getEmployee_mothername() {
		return employee_mothername;
	}

	public void setEmployee_mothername(String employee_mothername) {
		this.employee_mothername = employee_mothername;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	} 
	

}
