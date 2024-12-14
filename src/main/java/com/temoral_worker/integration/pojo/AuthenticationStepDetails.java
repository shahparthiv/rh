package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AuthenticationStepDetails {
    @JsonProperty("method")
    private String method;

    @JsonProperty("api_key")
    private String apiKey;

    @JsonProperty("base_url")
    private String baseUrl;

    @JsonProperty("headers")
    private List<Header> headers;

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public void setHeaders(List<Header> headers) {
        this.headers = headers;
    }

    // Getters and setters

    public static class Header {
        @JsonProperty("name")
        private String name;

        @JsonProperty("value")
        private String value;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        // Getters and setters
    }
}
