package org.example.core.exception;

import org.example.core.exception.base.ServiceException;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
public class LicenseDoesNotExistException extends ServiceException {
    public LicenseDoesNotExistException(String message) {
        super(message);
    }
}
