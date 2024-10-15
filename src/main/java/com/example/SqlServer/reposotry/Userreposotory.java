package com.example.SqlServer.reposotry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.SqlServer.model.User;


@Repository
public interface Userreposotory extends JpaRepository<User, Long>{

  	
	boolean existsByEmail(String email);
	
	    
	
	
	

}
