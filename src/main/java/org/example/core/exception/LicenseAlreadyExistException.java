package org.example.core.exception;

import org.example.core.exception.base.ServiceException;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
public class LicenseAlreadyExistException extends ServiceException {
    public LicenseAlreadyExistException(String message) {
        super(message);
    }
}
