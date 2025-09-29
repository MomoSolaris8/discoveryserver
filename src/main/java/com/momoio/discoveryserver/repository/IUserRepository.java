package com.momoio.discoveryserver.repository;

import com.momoio.discoveryserver.model.User;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 29.09.25
 */
public interface IUserRepository {
    User getUserByUsername(String username);
}
