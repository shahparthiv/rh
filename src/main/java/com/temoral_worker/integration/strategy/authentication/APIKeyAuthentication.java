package com.temoral_worker.integration.strategy.authentication;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class APIKeyAuthentication implements AuthenticationMethod {
    private static final Logger logger = LoggerFactory.getLogger(APIKeyAuthentication.class);

    @Override
    public void authenticate(Map<String, Object> details) {

        String apiKey = (String) details.get("api_key");
        String baseUrl = (String) details.get("base_url");
        logger.info("Authenticating to {} with API Key: {}", baseUrl, apiKey);
        // Perform authentication logic
    }
}