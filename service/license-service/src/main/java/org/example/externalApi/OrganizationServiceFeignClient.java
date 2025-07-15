package org.example.externalApi;

import org.example.externalApi.config.OrganizationServiceClientConfig;
import org.example.externalApi.dto.OrganizationDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
@FeignClient(name = "organization-service", configuration = OrganizationServiceClientConfig.class)
public interface OrganizationServiceFeignClient {

    String BASE_PATH = "api/v1/organization";
    String ORGANIZATION_ID = BASE_PATH + "/{organizationId}";

    @GetMapping(ORGANIZATION_ID)
    OrganizationDto getOrganization(@PathVariable Long organizationId);
}
