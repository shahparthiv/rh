package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HttpRequestStep extends Stepp {
    @JsonProperty("details")
    private HttpRequestStepDetails details;

    @Override
    public Object getDetails() {
        return details;
    }

    public void setDetails(HttpRequestStepDetails details) {
        this.details = details;
    }
}
