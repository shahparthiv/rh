package com.temoral_worker.integration.step;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class DataTransformationStep implements Step {
    private static final Logger logger = LoggerFactory.getLogger(DataTransformationStep.class);

    @Override
    public void execute(Map<String, Object> stepDetails) {
        // Implement Data Transformation Logic
        logger.info("Transforming Data: {}", stepDetails);
    }
}