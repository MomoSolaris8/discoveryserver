package com.momoio.discoveryserver.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.www.BasicAuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 29.09.25
 */
@Component
public class DiscoveryAuthenticationEntryPoint extends BasicAuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException {
        response.setHeader("WWW-Authenticate", "Basic real=" + getRealmName());
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        var writer = response.getWriter();
        //writer.println("HTTP Status 401 - " + exception.getMessage());
        writer.println("HTTP Status 401 -  You are not logged in");
        //response.setContentType("TEXT/HTML");
        /*writer.println("""
                <html>
                <head>
                </head>
                </html>
                """);*/
    }

    @Override
    public void afterPropertiesSet() {
        setRealmName("myreal");
        super.afterPropertiesSet();
    }
}

