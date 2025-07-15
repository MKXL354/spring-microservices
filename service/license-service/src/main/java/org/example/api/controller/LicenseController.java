package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.CreateLicenseRequestDto;
import org.example.api.dto.UpdateLicenseRequestDto;
import org.example.api.facade.LicenseFacade;
import org.example.core.exception.LicenseDoesNotExistException;
import org.example.core.exception.OrganizationDoesNotExistException;
import org.example.core.exception.OrganizationDoesNotHaveAccessToLicenseException;
import org.example.core.model.License;
import org.example.core.service.LicenseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
@RestController
@RequestMapping
@RequiredArgsConstructor
public class LicenseController implements LicenseFacade {

    private final LicenseService licenseService;

    public License createLicense(Long organizationId, CreateLicenseRequestDto requestDto) throws OrganizationDoesNotExistException {
        return licenseService.createLicense(organizationId, requestDto);
    }

    public License getLicense(Long organizationId, Long licenseId) throws LicenseDoesNotExistException,
            OrganizationDoesNotHaveAccessToLicenseException, OrganizationDoesNotExistException {
        return licenseService.getLicense(organizationId, licenseId);
    }

    public void deleteLicense(Long organizationId, Long licenseId) throws LicenseDoesNotExistException,
            OrganizationDoesNotHaveAccessToLicenseException, OrganizationDoesNotExistException {
        licenseService.deleteLicense(organizationId, licenseId);
    }

    public void updateLicense(Long organizationId, Long licenseId, UpdateLicenseRequestDto requestDto) throws LicenseDoesNotExistException,
            OrganizationDoesNotHaveAccessToLicenseException, OrganizationDoesNotExistException {
        licenseService.updateLicense(organizationId, licenseId, requestDto);
    }
}
