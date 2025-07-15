package org.example.core.exception;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
public class OrganizationDoesNotHaveAccessToLicenseException extends ServiceException {

    public OrganizationDoesNotHaveAccessToLicenseException(String message) {
        super(message);
    }
}
