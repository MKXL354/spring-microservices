package org.example.api.exception.base;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
public class ServiceRuntimeException extends RuntimeException {

    public ServiceRuntimeException(String message) {
        super(message);
    }
}
