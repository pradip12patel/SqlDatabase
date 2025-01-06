package com.example.SqlServer.model;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "OrderProduts")
public class Orderdhistory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "produt_id")
	private  long id;
	
	@Column(name = "name")
	 private String name;
	
	@Column(name = "description")
	    private String description;
	
	@Column(name = "originalPrice")
	    private double originalPrice;
	
	@Column(name = "discountedPrice")
	    private double discountedPrice;
	
	@Column(name = "discountPercentage")
	    private int discountPercentage;
	
 	@Column(name = "imageUrl")
	private String imageUrl;
 	
 	
 	private int amount;

	
	public String getImageUrl() {
		return imageUrl;
	}
	
	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}   


		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getOriginalPrice() {
			return originalPrice;
		}

		public void setOriginalPrice(double originalPrice) {
			this.originalPrice = originalPrice;
		}

		public double getDiscountedPrice() {
			return discountedPrice;
		}

		public void setDiscountedPrice(double discountedPrice) {
			this.discountedPrice = discountedPrice;
		}

		public int getDiscountPercentage() {
			return discountPercentage;
		}

		public void setDiscountPercentage(int discountPercentage) {
			this.discountPercentage = discountPercentage;
		}
		
		

		@Column(name = "Present")
		private Boolean inStock;


		public Boolean getInStock() {
			return inStock;
		}

		public void setInStock(Boolean inStock) {
			this.inStock = inStock;
		}

		
		
		@Column(name = "paymentId")
		private static String paymentId;
		
		@Column(name = "orderId")
	    private static String orderId;
	    

	    // Default Constructor
	    public Orderdhistory() {
	    }

	    // Parameterized Constructor
	    public Orderdhistory(String paymentId, String orderId, Integer productId) {
	        this.paymentId = paymentId;
	        this.orderId = orderId;
	        this.id = productId;
	    }

	    // Getters and Setters
	    public static String getPaymentId() {
	        return paymentId;
	    }

	    public void setPaymentId(String paymentId) {
	        this.paymentId = paymentId;
	    }

	    public static String getOrderId() {
	        return orderId;
	    }

	    public void setOrderId(String orderId) {
	        this.orderId = orderId;
	    }
//
//	    public  long getProductId() {
//	        return id;
//	    }

	    public void setProductId(Integer productId) {
	        this.id = productId;
	    }

	    @Override
	    public String toString() {
	        return "PaymentDetails{" +
	                "paymentId='" + paymentId + '\'' +
	                ", orderId='" + orderId + '\'' +
	                ", productId=" + id +
	                '}';
	    }

		
	    
	    
	    
	    

}
