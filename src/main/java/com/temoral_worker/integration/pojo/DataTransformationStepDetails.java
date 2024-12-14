package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class DataTransformationStepDetails {
    @JsonProperty("input_data")
    private String inputData;

    @JsonProperty("transformation")
    private List<Transformation> transformation;

    // Getters and setters

    public static class Transformation {
        @JsonProperty("extract_field")
        private String extractField;

        @JsonProperty("from")
        private String from;

        // Getters and setters
    }
}
