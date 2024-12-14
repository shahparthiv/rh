package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AuthenticationStep extends Stepp {
    @JsonProperty("details")
    private AuthenticationStepDetails details;

    @Override
    public Object getDetails() {
        return details;
    }

    public void setDetails(AuthenticationStepDetails details) {
        this.details = details;
    }
}