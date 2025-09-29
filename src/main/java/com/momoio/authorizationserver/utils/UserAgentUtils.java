package com.momoio.authorizationserver.utils;

import com.momoio.authorizationserver.domain.Analyzer;
import jakarta.servlet.http.HttpServletRequest;
import nl.basjes.parse.useragent.UserAgent;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 29.09.25
 */
public class UserAgentUtils {
    private static final String USER_AGENT_HEADER = "user-agent";
    private static final String X_FORWARDED_FOR_HEADER = "X-FORWARDED-FOR";

    public static String getDevice(HttpServletRequest request) {
        var uaa = Analyzer.getInstance();
        var agent = uaa.parse(request.getHeader(USER_AGENT_HEADER));
        return agent.getValue(UserAgent.DEVICE_NAME);

    }

    public static String getClient(HttpServletRequest request) {
        var uaa = Analyzer.getInstance();
        var agent = uaa.parse(request.getHeader(USER_AGENT_HEADER));
        return agent.getValue(UserAgent.AGENT_NAME);
    }

    public static String getIpAddress(HttpServletRequest request) {
        var ipAddress = "Unknown IP";
        if(request != null) {
            ipAddress = request.getHeader(X_FORWARDED_FOR_HEADER);
            if(ipAddress == null || ipAddress.isBlank()) {
                ipAddress = request.getRemoteAddr();
            }
        }
        return ipAddress;
    }
}
