package com.example.SqlServer.reposotry;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DiseaseRepository  {
    // Custom query method to find diseases by a description keyword
  ///  List<Disease> findBySymptomsContainingIgnoreCase(String symptom);
}

