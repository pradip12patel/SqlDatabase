package com.example.SqlServer.ontroller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.SqlServer.eeption.ResourceNotFoundException;
import com.example.SqlServer.model.Product;
import com.example.SqlServer.seriveImpl.AuthService;
import com.example.SqlServer.seriveImpl.QRCodeGeneratorService;
import com.example.SqlServer.serviceImpl.EmailService;
import com.example.SqlServer.servie.NewemployeeServie;
import com.example.SqlServer.servie.ProductService;
import com.google.zxing.WriterException;


@RestController
@RequestMapping("/products")
public class neww {
	

	
	private NewemployeeServie newemployservie;
	private ProductService productservice;
	

	@Autowired
	public neww(NewemployeeServie newemployservie,ProductService productservice) {
		super();
		this.newemployservie = newemployservie;
		this.productservice = productservice;
		
	} 
	
	
	@CrossOrigin(origins = "http://localhost:8083")
	@GetMapping("/search")
	public List<Product> searchProducts(@RequestParam(required = false, defaultValue = "") String query) {
	    return productservice.searchProducts(query);
	}

	
	@CrossOrigin(origins = "http://localhost:8083") 
		@PostMapping("/create")
		public ResponseEntity<Product> saveproduct(@RequestBody  Product pro) throws IOException{
			
		   System.out.println("ID: " + pro.getId());
		   System.out.println("Product Name: " + pro.getName());
	       System.out.println("Description: " + pro.getDescription());
	       System.out.println("DiscountedPrice: " + pro.getDiscountedPrice());
	       System.out.println("OriginalPrice: " + pro.getOriginalPrice());
	       System.out.println("DiscountPercentage: " + pro.getDiscountPercentage());
	  //     System.out.println("Image: " + pro.getImageUrl());
	       
//	       String fileName = image.getOriginalFilename();
//           Path path = Paths.get("uploads/" + fileName);
//           Files.write(path, image.getBytes());
	       
	       
	       System.out.println("-----------------------------------------------------");
			
			return new ResponseEntity<Product>(productservice.saveproduct(pro), HttpStatus.CREATED);
			
			  
		}
	
	
	 @CrossOrigin(origins = "http://localhost:8083")
	 @GetMapping("allproduct")
	    public List<Product> getAllProducts() {
		 
	        return productservice.getallproduct();
	    }

	
	 @CrossOrigin(origins = "http://localhost:8083")
	 @GetMapping("/retrive/{id}")
	    public ResponseEntity<Product> getProductById(@PathVariable Long id) {
		 
	        Optional<Product> product = Optional.of(productservice.getproductbyID(id));
	        return product.map(ResponseEntity::ok)
	                      .orElseGet(() -> ResponseEntity.notFound().build());
	    }
	
	 @PutMapping("update/{id}")
	    public ResponseEntity<Product> updateProduct(@PathVariable("id") Long id, @RequestBody Product product) {
		 
	/*        if (!productservice.getproductbyID(id).isPresent()) {
	            return ResponseEntity.notFound().build();
	        }
	        product.setId(id);
	        return ResponseEntity.ok(productservice.saveproduct(product));   */
	        
	        
	        return new ResponseEntity<Product>(productservice.updateproduct(product, id), HttpStatus.OK);
	    }
	

	 
	 @CrossOrigin(origins = "http://localhost:8083")
	 @PostMapping("/add")
	    public ResponseEntity<Product> addProduct(   @RequestBody Product product) {
	        Product savedProduct;

	        if (product.getId() > 0 && productservice.existsById(product.getId())) {
	           
	            Product existingProduct = productservice.findById(product.getId());  //.orElseThrow(() -> new ResourceNotFoundException("produt", "id", product));
	            product.setInStock(existingProduct.getInStock()); // Preserve the inStock status
	            savedProduct = productservice.save(product);
	        } else {
	           
	            product.setInStock(false);
	            savedProduct = productservice.save(product);
	        }

	        return ResponseEntity.ok(savedProduct);
	    }
	 
	

	 
	
	     

	 
                                                 
}
