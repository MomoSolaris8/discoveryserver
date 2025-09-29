package com.momoio.authorizationserver.security;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.stereotype.Component;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 29.09.25
 */
@Component
@AllArgsConstructor
public class UserAuthenticationManager {
    private final UserAuthenticationProvider authenticationProvider;

    @Bean
    public AuthenticationManager authenticationManager() {
        return new ProviderManager(authenticationProvider);
    }
}
