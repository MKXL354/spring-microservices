package org.example.api.controller;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.CreateLicenseRequestDto;
import org.example.api.dto.UpdateLicenseRequestDto;
import org.example.api.facade.LicenseFacade;
import org.example.core.exception.LicenseAlreadyExistException;
import org.example.core.exception.LicenseDoesNotExistException;
import org.example.core.model.License;
import org.example.core.service.LicenseService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
@RestController
@RequestMapping(LicenseFacade.BASE_PATH)
@RequiredArgsConstructor
public class LicenseController implements LicenseFacade {

    private final LicenseService licenseService;

    public License createLicense(CreateLicenseRequestDto requestDto) throws LicenseAlreadyExistException {
        return licenseService.createLicense(requestDto);
    }

    public License getLicense(Long licenseId) throws LicenseDoesNotExistException {
        return licenseService.getLicense(licenseId);
    }

    public void deleteLicense(Long licenseId) throws LicenseDoesNotExistException {
        licenseService.deleteLicense(licenseId);
    }

    public void updateLicense(UpdateLicenseRequestDto requestDto) throws LicenseDoesNotExistException {
        licenseService.updateLicense(requestDto);
    }
}
