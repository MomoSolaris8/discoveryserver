package com.momoio.discoveryserver.repository.implementation;

import com.momoio.discoveryserver.exception.ApiException;
import com.momoio.discoveryserver.model.User;
import com.momoio.discoveryserver.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Service;

import java.util.Map;

import static com.momoio.discoveryserver.query.UserQuery.*;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 29.09.25
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserRepositoryImpl implements IUserRepository {

    private final JdbcClient jdbc;

    @Override
    public User getUserByUsername(String username) {
        try {
            return jdbc.sql(SELECT_USER_BY_USERNAME_QUERY).param("username", username).query(User.class).single();
        } catch (EmptyResultDataAccessException exception) {
            log.error(exception.getMessage());
            throw new ApiException(String.format("No user found by username %s", username));
        } catch (Exception exception) {
            log.error(exception.getMessage());
            throw new ApiException("An error occurred. Please try again.");
        }
    }
}

