package com.example.SqlServer.reposotry;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.SqlServer.model.Product;


public interface ProductRepository extends JpaRepository<Product, Long>{

	List<Product> findByNameContainingIgnoreCase(String name);
	
	
}