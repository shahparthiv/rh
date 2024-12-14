package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class IntegrationConfig {
    @JsonProperty("name")
    private String name;

    @JsonProperty("description")
    private String description;

    @JsonProperty("steps")
    private List<Stepp> steps;

    // Getters and setters
}