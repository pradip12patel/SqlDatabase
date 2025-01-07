package com.example.SqlServer.seriveImpl;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.SqlServer.eeption.ResourceNotFoundException;
import com.example.SqlServer.model.Product;
import com.example.SqlServer.reposotry.ProductRepository;
import com.example.SqlServer.servie.ProductService;









@Service
public class ProductserviceIMPL implements ProductService {
	
	private ProductRepository productrepo;
	
	 public ProductserviceIMPL(ProductRepository productrepo)  {
		 
		 super();
		 this.productrepo = productrepo;
		 
	 }
	
	 public List<Product> searchProducts(String query) {
	        
		 
	        return productrepo.findByNameContainingIgnoreCase(query);
	    }
	
	

	@Override
	public Product saveproduct(Product product) {
		
		
		return productrepo.save(product);
	}

	@Override
	public List<Product> savesproduct(Product[] newproduct) {
		
     List<Product> productList = Arrays.asList(newproduct);
		
		return productrepo.saveAll(productList);
	}

	@Override
	public List<Product> getallproduct() {
		
		return productrepo.findAll();
	}

	@Override
	public Product getproductbyID(long id) {
		
		Optional<Product> pro = Optional.of(productrepo.findById(id));
		
	    return productrepo.findById(id);
	      //  .orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
	}


	@Override
	public Product updateproduct(Product pro, long id) {

		//we need to hek that employee eist or not in table
				Product existpro=productrepo.findById(id);    //.orElseThrow(() -> new ResourceNotFoundException("product", "id", id));
				
				existpro.setInStock((pro.getInStock()));
				existpro.setName((pro.getName()));
				existpro.setDescription(pro.getDescription());
				existpro.setOriginalPrice(pro.getOriginalPrice());
				existpro.setDiscountedPrice(pro.getDiscountedPrice());
				existpro.setDiscountPercentage(pro.getDiscountPercentage());
				
				//save eisting employee in DB
				
				productrepo.save(existpro);
				
				return existpro;
	}

	@Override
	public void deleteproduct(long id) {
		
     productrepo.findById(id);
		
		productrepo.deleteById(id);
		
	}

//	@Override
//    public Product updateProductInStock(Long id, Boolean inStock) {
//    	
//        Optional<Product> optionalProduct = productrepo.findById(id);
//        if (optionalProduct.isPresent()) {
//        	
//            Product product = optionalProduct.get();
//            product.setInStock(inStock);
//            
//            return productrepo.save(product);
//            
//        } 
//        else {
//            throw new RuntimeException("Product not found");
//        }
//    }



	 public boolean existsById(long id) {
	        return productrepo.existsById(id);
	    }

	    public Product findById(long id) {
	        return productrepo.findById(id);
	    }

	    public Product save(Product product) {
	        return productrepo.save(product);
	    }

       

   // Method to get product suggestions based on query
   public List<Product> getSuggestions(String query) {
	return productrepo.findByNameContainingIgnoreCase(query);
	
}

   
         


	
	
}
