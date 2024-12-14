package com.temoral_worker.integration.factory;


import com.temoral_worker.integration.step.*;

public class StepFactory {
    private StepFactory() {
        throw new IllegalStateException("Utility class");
    }
    public static Step getHandler(String stepType) {
        switch (stepType) {
            case "Authentication":
                return new AuthenticationStep();
            case "HTTP Request":
                return new HttpRequestStep();
            case "Data Transformation":
                return new DataTransformationStep();
            case "Action":
                return new ActionStep();
            default:
                throw new IllegalArgumentException("Unsupported step type: " + stepType);
        }
    }
}
