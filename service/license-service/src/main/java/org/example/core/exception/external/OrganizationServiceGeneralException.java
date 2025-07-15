package org.example.core.exception.external;

import org.example.core.exception.base.ServiceRuntimeException;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
public class OrganizationServiceGeneralException extends ServiceRuntimeException {

    public OrganizationServiceGeneralException(String message) {
        super(message);
    }
}
