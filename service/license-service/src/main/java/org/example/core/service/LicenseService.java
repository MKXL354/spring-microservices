package org.example.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.api.dto.CreateLicenseRequestDto;
import org.example.api.dto.UpdateLicenseRequestDto;
import org.example.core.exception.LicenseDoesNotExistException;
import org.example.core.exception.OrganizationDoesNotHaveAccessToLicenseException;
import org.example.core.invoker.OrganizationServiceInvoker;
import org.example.core.model.License;
import org.example.core.model.Organization;
import org.example.core.provider.LicenseProvider;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Locale;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class LicenseService {

    private final MessageSource messageSource;
    private final LicenseProvider licenseProvider;
    private final OrganizationServiceInvoker organizationServiceInvoker;

    public License createLicense(Long organizationId, CreateLicenseRequestDto requestDto) {
        Organization organization = organizationServiceInvoker.getOrganization(organizationId);
//        TODO: org not found in invoker
        License license = licenseProvider.save(requestDto, organization);
        log.info("license {} created", requestDto);
        return license;
    }

    public License getLicense(Long organizationId, Long licenseId) throws LicenseDoesNotExistException,
            OrganizationDoesNotHaveAccessToLicenseException {
        License license = licenseProvider.findByLicenseId(licenseId);
        Organization organization = organizationServiceInvoker.getOrganization(organizationId);
        checkOrganizationAccessToLicense(license, organization);
//        TODO: abstract or remove this away later. Leave for demonstration for now.
        String licenseRetrieved = messageSource.getMessage("license.get.success", new Object[]{licenseId}, Locale.US);
        log.info(licenseRetrieved);
        return license;
    }

    @Transactional
    public void updateLicense(Long organizationId, Long licenseId, UpdateLicenseRequestDto requestDto) throws LicenseDoesNotExistException,
            OrganizationDoesNotHaveAccessToLicenseException {
        License license = licenseProvider.findByLicenseId(licenseId);
        Organization organization = organizationServiceInvoker.getOrganization(organizationId);
        checkOrganizationAccessToLicense(license, organization);
        licenseProvider.save(licenseId, requestDto);
        log.info("license with id {} updated with values: {}", license.getLicenseId(), requestDto);
    }

    public void deleteLicense(Long organizationId, Long licenseId) throws LicenseDoesNotExistException,
            OrganizationDoesNotHaveAccessToLicenseException {
        License license = licenseProvider.findByLicenseId(licenseId);
        Organization organization = organizationServiceInvoker.getOrganization(organizationId);
        checkOrganizationAccessToLicense(license, organization);
        licenseProvider.deleteById(licenseId);
        log.info("license with id {} deleted", licenseId);
    }

    private void checkOrganizationAccessToLicense(License license, Organization organization) throws OrganizationDoesNotHaveAccessToLicenseException {
        if (!license.getOrganizationId().equals(organization.getOrganizationId())) {
            throw new OrganizationDoesNotHaveAccessToLicenseException(String.format(
                    "Organization with id %d does not have access to License with id %d", organization.getOrganizationId(), license.getLicenseId()));
        }
    }
}
