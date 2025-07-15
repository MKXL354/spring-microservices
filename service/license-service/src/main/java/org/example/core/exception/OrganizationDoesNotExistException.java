package org.example.core.exception;

import org.example.core.exception.base.ServiceException;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
public class OrganizationDoesNotExistException extends ServiceException {
    public OrganizationDoesNotExistException(String message) {
        super(message);
    }
}
