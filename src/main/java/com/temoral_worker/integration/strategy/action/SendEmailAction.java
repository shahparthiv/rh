package com.temoral_worker.integration.strategy.action;

import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SendEmailAction implements ActionType {

    private static final Logger logger = LoggerFactory.getLogger(SendEmailAction.class);

    @Override
    public void execute(Map<String, Object> details) {

        List<String> recipients = (List<String>) details.get("recipients");

        // implement the logic to send the email

        logger.info("Sending email via send email action to {}: ", recipients);

    }
}
