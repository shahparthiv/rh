package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class StepsWrapper {
    @JsonProperty("steps")
    private List<Stepp> steps;

    public List<Stepp> getSteps() {
        return steps;
    }

    public void setSteps(List<Stepp> steps) {
        this.steps = steps;
    }
}
