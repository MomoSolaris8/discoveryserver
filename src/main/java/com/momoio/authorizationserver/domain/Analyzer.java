package com.momoio.authorizationserver.domain;

import nl.basjes.parse.useragent.UserAgentAnalyzer;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 29.09.25
 */
public class Analyzer {
    private static UserAgentAnalyzer INSTANCE;

    public static UserAgentAnalyzer getInstance() {
        if(INSTANCE == null) {
            INSTANCE = UserAgentAnalyzer
                    .newBuilder()
                    .hideMatcherLoadStats()
                    .withCache(10000)
                    .build();
        }
        return INSTANCE;
    }
}