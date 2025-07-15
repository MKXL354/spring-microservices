package org.example.externalApi.assembler;

import org.example.core.exception.OrganizationDoesNotExistException;
import org.example.core.model.Organization;
import org.example.externalApi.dto.OrganizationDto;
import org.example.externalApi.errorHandling.exception.BaseOrganizationServiceException;
import org.example.externalApi.errorHandling.exception.ServiceOrganizationDoesNotExistException;
import org.springframework.stereotype.Component;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
@Component
public class OrganizationServiceAssembler {

    public Organization toOrganization(OrganizationDto organizationDto) {
        Organization organization = new Organization();
        organization.setOrganizationId(organizationDto.getId());
        organization.setName(organizationDto.getName());
        organization.setDescription(organizationDto.getDescription());
        return organization;
    }

    public void generateOrganizationServiceException(BaseOrganizationServiceException exception) throws OrganizationDoesNotExistException {
        if (exception instanceof ServiceOrganizationDoesNotExistException e) {
            throw new OrganizationDoesNotExistException(e.getMessage());
        } else {
            throw exception;
        }
    }
}
