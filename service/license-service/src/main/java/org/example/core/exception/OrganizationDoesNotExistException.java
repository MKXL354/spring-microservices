package org.example.core.exception;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
public class OrganizationDoesNotExistException extends ServiceException {
    public OrganizationDoesNotExistException(String message) {
        super(message);
    }
}
