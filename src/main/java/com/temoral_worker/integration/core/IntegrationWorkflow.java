package com.temoral_worker.integration.core;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface IntegrationWorkflow {
    @WorkflowMethod
    void executeIntegration(String yamlConfig);
}
