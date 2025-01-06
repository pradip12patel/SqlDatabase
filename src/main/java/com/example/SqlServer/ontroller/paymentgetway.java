package com.example.SqlServer.ontroller;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.SqlServer.model.Orderdhistory;
import com.example.SqlServer.model.Product;
import com.example.SqlServer.ontroller.userontroller.ApiResponse;
import com.example.SqlServer.reposotry.ProductRepository;
import com.razorpay.Order;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;

@RestController
public class paymentgetway {

    @CrossOrigin(origins = "http://localhost:8083")
    @PostMapping("/paymentOrder")
    public ResponseEntity<ApiResponse> createOrder(@RequestBody Product orderRequest) {
        try {
            // Validate request
            if (orderRequest.getAmount() <= 0) {
                return ResponseEntity.badRequest().body(new ApiResponse(false, "Invalid amount"));
            }

            // Initialize Razorpay client
            RazorpayClient razorpayClient = new RazorpayClient("rzp_test_t2INvChUAslTpz", "aRfv4DBkHu4NTYBTPIVf4fxw");

            // Create order request
            JSONObject orderRequestJson = new JSONObject();
           orderRequestJson.put("amount", orderRequest.getAmount()); // Amount in paisa
            orderRequestJson.put("currency", "INR");
            orderRequestJson.put("receipt", "receipt_" + orderRequest.getId());

            // Create order
            Order order = razorpayClient.orders.create(orderRequestJson);

            // Set paymentId and orderId in the response
            orderRequest.setPaymentId(order.get("id").toString());
            orderRequest.setOrderId(order.get("receipt").toString());

            // Prepare response
            Map<String, Object> response = new HashMap<>();
            response.put("message", "Payment details saved successfully");
            response.put("paymentId", orderRequest.getPaymentId());
            response.put("orderId", orderRequest.getOrderId());
            response.put("productId", orderRequest.getId());
            response.put("amount", orderRequest.getAmount());

            return ResponseEntity.ok(new ApiResponse(true, response));
            
        } catch (RazorpayException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new ApiResponse(false, "Error creating order: " + e.getMessage()));
        }
    }
    
    
    @Autowired
    private ProductRepository productRepository;
    
    @CrossOrigin(origins = "http://localhost:8083")
    @GetMapping("/paymentOrder/{id}")
    public ResponseEntity<ApiResponse> getPaymentDetails(@PathVariable long id) {
        try {
           
        	Product product = null;
			try {
				product = productRepository.findById(id);
			} catch (Exception e) {
			 
				e.printStackTrace();
			}

            if (product == null) {
                return ResponseEntity.badRequest().body(new ApiResponse(false, "Product not found"));
            }

            // Prepare the response data
            Map<String, Object> response = new HashMap<>();
            response.put("productId", product.getId());
            response.put("paymentId", product.getPaymentId());
            response.put("orderId", product.getOrderId());
            response.put("amount", product.getAmount());
            response.put("name", product.getName());
            response.put("original", product.getDiscountedPrice());
            response.put("status", "Success");

            return ResponseEntity.ok(new ApiResponse(true, response));
            
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new ApiResponse(false, "Error fetching payment details"));
        }
    }
    
    
    
    
    
    
    
    

    // ApiResponse class
    public static class ApiResponse {
        private boolean success;
        private Object response;

        public ApiResponse(boolean success, Object response) {
            this.success = success;
            this.response = response;
        }

        public boolean isSuccess() {
            return success;
        }

        public void setSuccess(boolean success) {
            this.success = success;
        }

        public Object getResponse() {
            return response;
        }

        public void setResponse(Object response) {
            this.response = response;
        }
    }
}
