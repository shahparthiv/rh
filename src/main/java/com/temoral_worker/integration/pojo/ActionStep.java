package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionStep extends Stepp {
    @JsonProperty("details")
    private ActionStepDetails details;

    @Override
    public Object getDetails() {
        return details;
    }

    public void setDetails(ActionStepDetails details) {
        this.details = details;
    }
}
