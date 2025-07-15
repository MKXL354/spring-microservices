package org.example.core.invoker;

import org.example.core.exception.OrganizationDoesNotExistException;
import org.example.core.model.Organization;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
public interface OrganizationServiceInvoker {

    Organization getOrganization(Long organizationId) throws OrganizationDoesNotExistException;
}
