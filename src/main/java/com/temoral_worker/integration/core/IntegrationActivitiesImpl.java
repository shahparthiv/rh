package com.temoral_worker.integration.core;

import com.temoral_worker.integration.factory.StepFactory;
import com.temoral_worker.integration.step.Step;
import io.temporal.activity.Activity;
import io.temporal.activity.DynamicActivity;
import io.temporal.common.converter.EncodedValues;
import io.temporal.failure.ApplicationFailure;

import java.util.HashMap;
import java.util.Map;

public class IntegrationActivitiesImpl implements DynamicActivity {

    @Override
    public Map<String, Object> execute(EncodedValues args) {
        Map<String, Object> returnContext = new HashMap<>();
        try {
            // Activity logic
            Map<String, Object> stepDetails = args.get(0, Map.class);
            Map<String, Object> context = args.get(1, Map.class);
            String stepType = Activity.getExecutionContext().getInfo().getActivityType();
            Step step = StepFactory.getHandler(stepType);

            returnContext = step.execute(stepDetails, context);
        } catch (Exception e) {
            throw ApplicationFailure.newFailure("General error occurred", "GeneralErrorType", e);
        }

        return returnContext;
    }
}
