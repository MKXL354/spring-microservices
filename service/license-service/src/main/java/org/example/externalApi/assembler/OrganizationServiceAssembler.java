package org.example.externalApi.assembler;

import org.example.core.model.Organization;
import org.example.externalApi.dto.OrganizationDto;
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
}
