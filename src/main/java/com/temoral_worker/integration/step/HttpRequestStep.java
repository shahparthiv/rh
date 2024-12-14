package com.temoral_worker.integration.step;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

public class HttpRequestStep implements Step {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestStep.class);

    @Override
    public Map<String, Object> execute(Map<String, Object> stepDetails, Map<String, Object> context) {
        // Implement HTTP Request Logic
        logger.info("Performing HTTP Request: {}", stepDetails);
        context.put("HttpRequestStep", "done");
        return context;
    }
}
