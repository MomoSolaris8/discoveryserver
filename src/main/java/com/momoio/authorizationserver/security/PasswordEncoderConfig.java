package com.momoio.authorizationserver.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 29.09.25
 */
@Configuration
public class PasswordEncoderConfig {
    public static final int STRENGTH = 12;

    @Bean
    public BCryptPasswordEncoder encoder() {
        return new BCryptPasswordEncoder(STRENGTH);
    }
}
