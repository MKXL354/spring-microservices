package org.example.core.exception;

import org.example.core.exception.base.ServiceException;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
public class OrganizationDoesNotHaveAccessToLicenseException extends ServiceException {

    public OrganizationDoesNotHaveAccessToLicenseException(String message) {
        super(message);
    }
}
