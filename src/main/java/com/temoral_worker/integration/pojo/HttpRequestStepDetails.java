package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HttpRequestStepDetails {
    @JsonProperty("endpoint")
    private String endpoint;

    @JsonProperty("method")
    private String method;

    @JsonProperty("headers")
    private List<Header> headers;

    @JsonProperty("query_parameters")
    private List<QueryParameter> queryParameters;

    // Getters and setters

    public static class Header {
        @JsonProperty("name")
        private String name;

        @JsonProperty("value")
        private String value;

        // Getters and setters
    }


    public static class QueryParameter {
        @JsonProperty("name")
        private String name;

        @JsonProperty("value")
        private String value;

        // Getters and setters
    }
}
