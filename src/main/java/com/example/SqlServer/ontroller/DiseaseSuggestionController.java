package com.example.SqlServer.ontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SqlServer.model.DiseaseDescriptionRequest;
import com.example.SqlServer.reposotry.DiseaseRepository;

import java.util.List;

@RestController
@RequestMapping("/api/disease")
public class DiseaseSuggestionController {

//    @Autowired
//    private DiseaseRepository diseaseRepository;
//
//    @PostMapping("/suggest")
//    public ResponseEntity<Disease> suggestDisease(@RequestBody DiseaseDescriptionRequest request) {
//        String userDescription = request.getDescription().toLowerCase();
//
//        // Fetch diseases matching the description
//        List<Disease> matchingDiseases = diseaseRepository.findBySymptomsContainingIgnoreCase(userDescription);
//
//        if (matchingDiseases.isEmpty()) {
//            return ResponseEntity.status(HttpStatus.NOT_FOUND)
//                                 .body(new Disease("Unknown", "No matching disease found", "Unknown area", "Consult a physician for proper diagnosis"));
//        }
//
//        // For simplicity, return the first match (you can implement better scoring or ranking)
//        return ResponseEntity.ok(matchingDiseases.get(0));
//    }
}
