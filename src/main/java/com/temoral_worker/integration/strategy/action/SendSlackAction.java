package com.temoral_worker.integration.strategy.action;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendSlackAction implements ActionType {
    private static final Logger logger = LoggerFactory.getLogger(SendSlackAction.class);

    @Override
    public void execute(Map<String, Object> details) {
        String webhookUrl = (String) details.get("webhook_url");
        String message = (String) details.get("message");
        logger.info("Sending Slack message to {} : {}", webhookUrl, message);
        // Perform Slack notification logic
    }
}