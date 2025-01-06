package com.example.SqlServer.ontroller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.SqlServer.seriveImpl.ApiAggregationService;

@RestController
@RequestMapping("/api")
public class ApiAggregationController {

    private final ApiAggregationService apiAggregationService;

    public ApiAggregationController(ApiAggregationService apiAggregationService) {
        this.apiAggregationService = apiAggregationService;
    }

    @GetMapping("/details_anaya/{paymentId}")
    public ResponseEntity<Map<String, Object>> getAllDetails(@PathVariable String paymentId) {
        Map<String, Object> allDetails = apiAggregationService.getAllDetails(paymentId);
        return ResponseEntity.ok(allDetails);
    }
}

