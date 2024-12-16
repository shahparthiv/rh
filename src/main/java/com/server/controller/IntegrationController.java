package com.server.controller;

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
public class IntegrationController {
    private static final Logger logger = LoggerFactory.getLogger(IntegrationController.class);

    private String loadYamlConfig(String resourcePath) throws IOException {
        InputStream inputStream = IntegrationController.class.getClassLoader().getResourceAsStream(resourcePath);
        if (inputStream == null) {
            throw new IllegalArgumentException("YAML configuration file not found: " + resourcePath);
        }
        return new String(inputStream.readAllBytes());
    }

    @GetMapping("/runIntegrarion")
    public String rh() throws IOException {


        logger.info("Hello {}","RH");
        // Make an HTTP call to downstream service with the custom headers

        //We can have a code get the file from client but as of now I have added the yaml file in resource directory.
        // We can write logic to validate the yml file. In this type of feature validation is very crucial task as
        // the whole integration is dependent on it.
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
