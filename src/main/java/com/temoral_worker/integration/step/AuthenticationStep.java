package com.temoral_worker.integration.step;

import com.temoral_worker.integration.factory.AuthenticationFactory;
import com.temoral_worker.integration.strategy.authentication.AuthenticationMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Map;

// Implementations of Step Handlers
public class AuthenticationStep implements Step {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationStep.class);

    @Override
    public void execute(Map<String, Object> stepDetails) {
        // Implement Authentication Logic

        AuthenticationMethod authMethod = AuthenticationFactory.getAuthenticationMethod(stepDetails.get("method").toString());
        authMethod.authenticate(stepDetails);
        logger.info("Authenticated using : {}", stepDetails.get("method"));
    }
}
