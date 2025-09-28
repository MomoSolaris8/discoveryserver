package com.momoio.authorizationserver.exception;

/**
 * @author Momo
 * @version 1.0
 * @email momosunshine5@gmail.com
 * @since 28.09.25
 */
public class ApiException extends RuntimeException {
    public ApiException(String message) { super(message); }
}