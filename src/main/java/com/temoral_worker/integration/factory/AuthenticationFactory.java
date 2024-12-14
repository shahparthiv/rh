package com.temoral_worker.integration.factory;


import com.temoral_worker.integration.strategy.authentication.APIKeyAuthentication;
import com.temoral_worker.integration.strategy.authentication.AuthenticationMethod;
import com.temoral_worker.integration.strategy.authentication.OAuthAuthentication;

public class AuthenticationFactory {

    private AuthenticationFactory() {
        throw new IllegalStateException("Utility class");
    }
    public static AuthenticationMethod getAuthenticationMethod(String method) {
        switch (method) {
            case "API Key":
                return new APIKeyAuthentication();
            case "OAuth":
                return new OAuthAuthentication();
            default:
                throw new IllegalArgumentException("Unsupported authentication method: " + method);
        }
    }
}
