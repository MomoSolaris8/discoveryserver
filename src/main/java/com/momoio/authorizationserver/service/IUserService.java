package com.momoio.authorizationserver.service;

import com.momoio.authorizationserver.model.User;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 29.09.25
 */
public interface IUserService {
    User getUserByEmail(String email);
    void resetLoginAttempts(String userUuid);
    void updateLoginAttempts(String email);
    void setLastLogin(Long userId);
    void addLoginDevice(Long userId, String deviceName, String client, String ipAddress);
    boolean verifyQrCode(String userUuid, String code);
}
