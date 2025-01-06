package com.example.SqlServer.reposotry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.SqlServer.model.User;


@Repository
public interface signinreposotory extends JpaRepository<User, Long> {

	 
	User findByEmail(String email);
 
	 boolean existsByEmail(String email);

	 
	 
	 Optional<User> findByemail(String email);
	 
	 boolean existsByemail(String email);
}
