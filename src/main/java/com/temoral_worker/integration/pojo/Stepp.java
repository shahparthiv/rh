package com.temoral_worker.integration.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "step_type"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = AuthenticationStep.class, name = "Authentication"),
        @JsonSubTypes.Type(value = HttpRequestStep.class, name = "HTTP Request"),
        @JsonSubTypes.Type(value = DataTransformationStep.class, name = "Data Transformation"),
        @JsonSubTypes.Type(value = ActionStep.class, name = "Action")
})
public abstract class Stepp {
    @JsonProperty("step_name")
    private String stepName;

    @JsonProperty("step_type")
    private String stepType;

    public String getStepType() {
        return stepType;
    }

    public void setStepType(String stepType) {
        this.stepType = stepType;
    }

    public String getStepName() {
        return stepName;
    }

    public void setStepName(String stepName) {
        this.stepName = stepName;
    }

    public abstract Object getDetails();
}