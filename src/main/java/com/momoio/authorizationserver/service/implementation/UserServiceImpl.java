package com.momoio.authorizationserver.service.implementation;

import com.momoio.authorizationserver.model.User;
import com.momoio.authorizationserver.repository.IUserRepository;
import com.momoio.authorizationserver.service.IUserService;
import com.momoio.authorizationserver.utils.UserUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 29.09.25
 */
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;

    @Override
    public User getUserByEmail(String email) {
        return userRepository.getUserByEmail(email);
    }

    @Override
    public void resetLoginAttempts(String userUuid) {
        userRepository.resetLoginAttempts(userUuid);
    }

    @Override
    public void updateLoginAttempts(String email) {
        userRepository.updateLoginAttempts(email);
    }

    @Override
    public void setLastLogin(Long userId) {
        userRepository.setLastLogin(userId);
    }

    @Override
    public void addLoginDevice(Long userId, String deviceName, String client, String ipAddress) {
        userRepository.addLoginDevice(userId, deviceName, client, ipAddress);
    }

    @Override
    public boolean verifyQrCode(String userUuid, String code) {
        var user = userRepository.getUserByUuid(userUuid);
        return UserUtils.verifyQrCode(user.getQrCodeSecret(), code);
    }
}