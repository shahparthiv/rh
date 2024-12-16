package com.temoral_worker.integration.core;

import com.temoral_worker.integration.step.AuthenticationStep;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.common.converter.EncodedValues;
import io.temporal.failure.ApplicationFailure;
import io.temporal.workflow.ActivityStub;
import io.temporal.workflow.Workflow;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.yaml.snakeyaml.Yaml;


import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IntegrationWorkflowImpl implements IntegrationWorkflow {

    private static final Logger logger = LoggerFactory.getLogger(IntegrationWorkflowImpl.class);
    private final ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofMinutes(1))
            // We can set the proper integrations tep retry logic
            /*.setRetryOptions(RetryOptions.newBuilder()
                    .setMaximumAttempts(3)
                    .setInitialInterval(Duration.ofSeconds(2))
                    .setMaximumInterval(Duration.ofMinutes(1))
                    .setDoNotRetry("SpecificErrorType") // Non-retryable exception
                    .build())*/
            .build();

    @Override
    public Object executeIntegration(String yamlConfig) {
        Map<String, Object> context = new HashMap<>();
        try {
            Yaml yaml = new Yaml();
            Map<String, Object> config = yaml.load(yamlConfig);


            // Extract steps from YAML

            List<Map<String, Object>> steps = (List<Map<String, Object>>) config.get("steps");

            // Execute each step
            for (Map<String, Object> step : steps) {
                String stepType = (String) step.get("step_type");
                ActivityStub ac = Workflow.newUntypedActivityStub(options);
                //ac.execute(stepType, Map.class, step.get("details"));
                context = ac.execute(stepType, Map.class, step.get("details"), context);
            }


        } catch (ApplicationFailure e) {
            if ("SpecificErrorType".equals(e.getType())) {
                // Handle specific error
            } else {
                // Handle general errors
            }
        }
        return context;
    }
}
