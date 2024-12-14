package com.temoral_worker.integration.core;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.converter.EncodedValues;
import io.temporal.workflow.ActivityStub;
import io.temporal.workflow.Workflow;
import org.yaml.snakeyaml.Yaml;


import java.time.Duration;
import java.util.List;
import java.util.Map;

public class IntegrationWorkflowImpl implements IntegrationWorkflow {

    private final ActivityOptions options = ActivityOptions.newBuilder()
            .setStartToCloseTimeout(Duration.ofMinutes(1))
            .build();

    public Object execute(EncodedValues args) {
        String yamlConfig = args.get(0, String.class);

        Yaml yaml = new Yaml();
        Map<String, Object> config = yaml.load(yamlConfig);

        // Extract steps from YAML
        List<Map<String, Object>> steps = (List<Map<String, Object>>) config.get("steps");

        // Execute each step
        for (Map<String, Object> step : steps) {
            String stepType = (String) step.get("step_type");
            ActivityStub ac = Workflow.newUntypedActivityStub(options);
            ac.execute(stepType, Map.class, step);
        }
        return null;
    }

    @Override
    public void executeIntegration(String yamlConfig) {
        Yaml yaml = new Yaml();
        Map<String, Object> config = yaml.load(yamlConfig);


        // Extract steps from YAML

        List<Map<String, Object>> steps = (List<Map<String, Object>>) config.get("steps");
        /*
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<Stepp> stepsPojo = steps.stream()
                    .map(rawStep -> mapper.convertValue(rawStep, Stepp.class))
                    .toList();

        for(Stepp s: stepsPojo){
            ActivityStub ac = Workflow.newUntypedActivityStub(options);
            ac.execute(s.getStepType(), Stepp.class, s);
        }*/


        // Execute each step
        for (Map<String, Object> step : steps) {
            String stepType = (String) step.get("step_type");
            ActivityStub ac = Workflow.newUntypedActivityStub(options);
            ac.execute(stepType, Map.class, step.get("details"));
        }
    }
}
