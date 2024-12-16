package com.temoral_worker.integration.core;

import com.temoral_worker.integration.step.AuthenticationStep;
import io.temporal.activity.ActivityOptions;
import io.temporal.common.converter.EncodedValues;
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
            .build();

    @Override
    public Object executeIntegration(String yamlConfig) {
        Yaml yaml = new Yaml();
        Map<String, Object> config = yaml.load(yamlConfig);
        Map<String, Object> context = new HashMap<>();


        // Extract steps from YAML

        List<Map<String, Object>> steps = (List<Map<String, Object>>) config.get("steps");

        // Execute each step
        for (Map<String, Object> step : steps) {
            String stepType = (String) step.get("step_type");
            ActivityStub ac = Workflow.newUntypedActivityStub(options);
            //ac.execute(stepType, Map.class, step.get("details"));
            context = ac.execute(stepType, Map.class, step.get("details"), context);
        }

        logger.info("Integration Workflow Completed Successfully.");
        return context;
    }
}
