package com.temoral_worker.integration.strategy.authentication;

import java.util.Map;

public interface AuthenticationMethod {
    void authenticate(Map<String, Object> details);
}
