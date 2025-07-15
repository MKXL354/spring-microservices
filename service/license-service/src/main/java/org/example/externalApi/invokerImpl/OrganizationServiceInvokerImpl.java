package org.example.externalApi.invokerImpl;

import lombok.RequiredArgsConstructor;
import org.example.core.invoker.OrganizationServiceInvoker;
import org.example.core.model.Organization;
import org.example.externalApi.OrganizationServiceFeignClient;
import org.example.externalApi.assembler.OrganizationServiceAssembler;
import org.example.externalApi.dto.OrganizationDto;
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
    public Organization getOrganization(Long organizationId) {
        OrganizationDto dto = organizationServiceFeignClient.getOrganization(organizationId);
        return organizationServiceAssembler.toOrganization(dto);
    }
}
