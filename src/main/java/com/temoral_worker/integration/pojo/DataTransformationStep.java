package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DataTransformationStep extends Stepp {
    @JsonProperty("details")
    private DataTransformationStepDetails details;

    @Override
    public Object getDetails() {
        return details;
    }

    public void setDetails(DataTransformationStepDetails details) {
        this.details = details;
    }
}
