package org.example.api.exception;

import org.example.api.exception.base.ServiceException;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
public class OrganizationAlreadyExistException extends ServiceException {
    public OrganizationAlreadyExistException(String message) {
        super(message);
    }
}
