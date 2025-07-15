package org.example.core.exception;

import org.example.core.exception.base.ServiceRuntimeException;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
public class LicenseDoesNotExistException extends ServiceRuntimeException {
    public LicenseDoesNotExistException(String message) {
        super(message);
    }
}
