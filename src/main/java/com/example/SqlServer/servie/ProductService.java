package com.example.SqlServer.servie;

import java.util.List;
import java.util.Optional;

import com.example.SqlServer.model.Product;


public interface ProductService {
	
	  Product saveproduct(Product product);
	  
	  List<Product> savesproduct(Product[] newproduct);
		
		List<Product>  getallproduct();
		
		Product getproductbyID(long id);
		
		Product updateproduct(Product pro, long id);
		
		void deleteproduct(long id);
		
		 boolean existsById(long id);
	   
	    Product findById(long id);

	    Product save(Product product);

		List<Product> searchProducts(String query);
	   
	    List<Product> getSuggestions(String query);
	
	
	
	
	
	
	
	
	
	
	
	
	

}
