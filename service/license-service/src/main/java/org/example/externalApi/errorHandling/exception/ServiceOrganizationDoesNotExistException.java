package org.example.externalApi.errorHandling.exception;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
public class ServiceOrganizationDoesNotExistException extends BaseOrganizationServiceException {

    public ServiceOrganizationDoesNotExistException(String message) {
        super(message);
    }
}
