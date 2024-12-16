package com.temoral_worker.integration.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class DataTransformationStep implements Step {
    private static final Logger logger = LoggerFactory.getLogger(DataTransformationStep.class);

    @Override
    public Map<String, Object> execute(Map<String, Object> stepDetails, Map<String, Object> context) {

        logger.info("Performing DataTransformationStep");

        // Implement Data Transformation Logic
        context.put("DataTransformationStep", "done");
        logger.info("DataTransformationStep step completed successfully.");
        return context;
    }
}