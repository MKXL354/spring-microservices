package org.example.externalApi.invokerImpl;

import lombok.RequiredArgsConstructor;
import org.example.core.exception.OrganizationDoesNotExistException;
import org.example.core.invoker.OrganizationServiceInvoker;
import org.example.core.model.Organization;
import org.example.externalApi.assembler.OrganizationServiceAssembler;
import org.example.externalApi.dto.OrganizationDto;
import org.example.externalApi.errorHandling.exception.BaseOrganizationServiceException;
import org.example.externalApi.feign.OrganizationServiceFeignClient;
import org.springframework.stereotype.Component;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
@Component
@RequiredArgsConstructor
public class OrganizationServiceInvokerImpl implements OrganizationServiceInvoker {

    private final OrganizationServiceFeignClient organizationServiceFeignClient;
    private final OrganizationServiceAssembler organizationServiceAssembler;

    @Override
    public Organization getOrganization(Long organizationId) throws OrganizationDoesNotExistException {
        try {
            OrganizationDto dto = organizationServiceFeignClient.getOrganization(organizationId);
            return organizationServiceAssembler.toOrganization(dto);
        } catch (BaseOrganizationServiceException e) {
            organizationServiceAssembler.generateOrganizationServiceException(e);
            return null;
        }
    }
}
