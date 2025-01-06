package com.example.SqlServer.seriveImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiAggregationService {

    private final RestTemplate restTemplate;

    // Constructor to initialize RestTemplate
    public ApiAggregationService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();
    }

    // Method to aggregate details from multiple APIs
    public Map<String, Object> getAllDetails(String paymentId) {
        // Call /paymentOrder/{id} with the ID
        Map<String, Object> users = restTemplate.exchange(
            "http://localhost:8082/paymentOrder/{id}",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<Map<String, Object>>() {},
            paymentId // Pass the ID here
        ).getBody();

        // Call /api/family/members
        List<Map<String, Object>> orders = restTemplate.exchange(
            "http://localhost:8082/api/family/members",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Map<String, Object>>>() {}
        ).getBody();

        // Call /products/allproduct
        List<Map<String, Object>> products = restTemplate.exchange(
            "http://localhost:8082/products/allproduct",
            HttpMethod.GET,
            null,
            new ParameterizedTypeReference<List<Map<String, Object>>>() {}
        ).getBody();

        // Aggregate responses
        Map<String, Object> aggregatedResponse = new HashMap<>();
        aggregatedResponse.put("Payment", users);    // Response from paymentOrder API
        aggregatedResponse.put("family", orders);    // Response from family/members API
        aggregatedResponse.put("products", products); // Response from allproduct API
       

        return aggregatedResponse; // Return the aggregated data
    }
}
