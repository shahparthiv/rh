package com.temoral_worker.integration.step;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class HttpRequestStep implements Step {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestStep.class);

    @Override
    public void execute(Map<String, Object> stepDetails) {
        // Implement HTTP Request Logic
        logger.info("Performing HTTP Request: {}", stepDetails);
    }
}
