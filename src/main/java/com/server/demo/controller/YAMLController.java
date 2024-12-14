package com.server.demo.controller;

import com.temoral_worker.integration.core.IntegrationWorkflow;
import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;
import io.temporal.serviceclient.WorkflowServiceStubs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;

@RestController
public class YAMLController {
    private static final Logger logger = LoggerFactory.getLogger(YAMLController.class);

    private String loadYamlConfig(String resourcePath) throws IOException {
        InputStream inputStream = YAMLController.class.getClassLoader().getResourceAsStream(resourcePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("YAML configuration file not found: " + resourcePath);
        }
        return new String(inputStream.readAllBytes());
    }

    @GetMapping("/rh/submit")
    public String rh() throws IOException {


        logger.info("Hello {}","RH");
        // Make an HTTP call to downstream service with the custom headers

        String ymlConfig = loadYamlConfig("rh/cs.yml");

        WorkflowServiceStubs service = WorkflowServiceStubs.newLocalServiceStubs();
        WorkflowClient client = WorkflowClient.newInstance(service);


        IntegrationWorkflow workflow =
                client.newWorkflowStub(
                        IntegrationWorkflow.class,
                        WorkflowOptions.newBuilder()
                                .setWorkflowId("rh-workflow")
                                .setTaskQueue("rh-task-queue")
                                .build());

        WorkflowClient.start(workflow::executeIntegration, ymlConfig);

        return "Integration submitted successfully";
    }
}
