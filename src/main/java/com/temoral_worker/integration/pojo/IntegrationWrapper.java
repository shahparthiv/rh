package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IntegrationWrapper {
    @JsonProperty("integration")
    private IntegrationConfig integration;

    public IntegrationConfig getIntegration() {
        return integration;
    }

    public void setIntegration(IntegrationConfig integration) {
        this.integration = integration;
    }
}