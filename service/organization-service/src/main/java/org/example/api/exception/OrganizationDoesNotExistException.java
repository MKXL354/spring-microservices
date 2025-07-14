package org.example.api.exception;

import org.example.api.exception.base.ServiceException;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
public class OrganizationDoesNotExistException extends ServiceException {
    public OrganizationDoesNotExistException(String message) {
        super(message);
    }
}
