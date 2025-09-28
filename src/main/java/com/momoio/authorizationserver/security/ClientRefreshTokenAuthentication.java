package com.momoio.authorizationserver.security;

import org.springframework.security.oauth2.core.ClientAuthenticationMethod;
import org.springframework.security.oauth2.server.authorization.authentication.OAuth2ClientAuthenticationToken;
import org.springframework.security.oauth2.server.authorization.client.RegisteredClient;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 28.09.25
 */
public class ClientRefreshTokenAuthentication extends OAuth2ClientAuthenticationToken {

    public ClientRefreshTokenAuthentication(String clientId) {
        super(clientId, ClientAuthenticationMethod.NONE, null, null);
    }

    public ClientRefreshTokenAuthentication(RegisteredClient registeredClient) {
        super(registeredClient, ClientAuthenticationMethod.NONE, null);
    }
}