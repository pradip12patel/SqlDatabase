package com.example.SqlServer.reposotry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SqlServer.model.NewEmployee;

public interface Newemployeereposotory extends JpaRepository<NewEmployee, Long>{
	
	

}
