package com.example.SqlServer.model;

public class DiseaseDescriptionRequest {
    private String description;

    // Constructor
    public DiseaseDescriptionRequest() {}

    public DiseaseDescriptionRequest(String description) {
        this.description = description;
    }

    // Getter and setter
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
