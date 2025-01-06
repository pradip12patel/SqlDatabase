package com.example.SqlServer.ontroller;

import com.example.SqlServer.dto.AddressDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class OrderController {

	@CrossOrigin(origins = "http://localhost:8083")
    @PostMapping("/order")
    public ResponseEntity<String> submitOrder(@RequestBody AddressDTO address) {
        // Handle order processing logic here (e.g., save to database, validate details, etc.)
        System.out.println("Order received for: " + address.getName());

        // For demonstration, just return a success message
        return ResponseEntity.ok("Order address submitted successfully for " + address.getName());
    }
}
