package com.temoral_worker.integration.strategy.authentication;

import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OAuthAuthentication implements AuthenticationMethod {
    private static final Logger logger = LoggerFactory.getLogger(OAuthAuthentication.class);

    @Override
    public void authenticate(Map<String, Object> details) {
        String clientId = (String) details.get("client_id");
        String tokenUrl = (String) details.get("token_url");
        logger.info("Authenticating to {} with Oauth Client ID: {}",tokenUrl, clientId);
        // Perform authentication logic
    }
}
