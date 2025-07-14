package org.example.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.api.dto.CreateOrganizationRequestDto;
import org.example.api.dto.UpdateOrganizationRequestDto;
import org.example.api.exception.OrganizationAlreadyExistException;
import org.example.api.exception.OrganizationDoesNotExistException;
import org.example.repository.OrganizationJpaRepository;
import org.example.repository.entity.Organization;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mehdi Kamali
 * @since 14/07/2025
 */
@RestController
@RequestMapping(path = "api/v1/organization")
@RequiredArgsConstructor
@Slf4j
public class OrganizationController {

    private final OrganizationJpaRepository organizationJpaRepository;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Organization createOrganization(@Valid @RequestBody CreateOrganizationRequestDto requestDto) throws OrganizationAlreadyExistException {
        if (organizationJpaRepository.findByName(requestDto.getName()) != null) {
            throw new OrganizationAlreadyExistException(String.format("organization %s already exist", requestDto.getName()));
        }
        Organization organization = new Organization();
        organization.setName(requestDto.getName());
        organization.setDescription(requestDto.getDescription());
        log.info("organization {} created", requestDto);
        return organizationJpaRepository.save(organization);
    }

    @PatchMapping(path = "{organizationId}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void updateOrganization(@PathVariable Long organizationId, @Valid @RequestBody UpdateOrganizationRequestDto requestDto) throws OrganizationDoesNotExistException {
        Organization organization = organizationJpaRepository.findById(organizationId).orElseThrow(() -> new OrganizationDoesNotExistException(
            String.format("organization %d does not exist", organizationId)));
        organization.setDescription(requestDto.getDescription());
        log.info("license with id {} updated with values: {}", organizationId, requestDto);
        organizationJpaRepository.save(organization);
    }

    @GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Organization getOrganization(@PathVariable Long id) throws OrganizationDoesNotExistException {
        return organizationJpaRepository.findById(id).orElseThrow(() -> new OrganizationDoesNotExistException(
            String.format("organization %d does not exist", id)));
    }

    @DeleteMapping(path = "{organizationId}")
    public void deleteOrganization(@PathVariable Long organizationId) throws OrganizationDoesNotExistException {
        Organization organization = organizationJpaRepository.findById(organizationId).orElseThrow(() -> new OrganizationDoesNotExistException(
            String.format("organization %d does not exist", organizationId)));
        log.info("organization with id {} deleted", organizationId);
        organizationJpaRepository.delete(organization);
    }
}
