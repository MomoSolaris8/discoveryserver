package com.momoio.discoveryserver.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;


import static com.momoio.discoveryserver.constants.Roles.APP_READ;


/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 28.09.25
 */

@Slf4j
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class FilterChainConfig {
    private final DiscoveryUserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.ignoringRequestMatchers("/eureka/**"))
                .userDetailsService(userDetailsService)
                .exceptionHandling(exception -> exception.accessDeniedHandler(new DiscoveryAccessDeniedHandler()))
                .authorizeHttpRequests( authorize -> authorize
                        .requestMatchers("/eureka/fonts/**", "/eureka/css/**", "/eureka/js/**", "/eureka/images/**", "/icon/**").permitAll()
                        .requestMatchers("/eureka/**").hasAnyAuthority(APP_READ)
                        .requestMatchers("/**").hasAnyAuthority(APP_READ)
                        .anyRequest().authenticated())
                .httpBasic(httpBasic -> httpBasic.authenticationEntryPoint(new DiscoveryAuthenticationEntryPoint()));
        return http.build();
    }
}


