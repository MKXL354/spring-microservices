package org.example.externalApi.errorHandling.exception;

import org.example.core.exception.ServiceRuntimeException;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
public class BaseOrganizationServiceException extends ServiceRuntimeException {

    public BaseOrganizationServiceException(String message) {
        super(message);
    }
}
