package org.example.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.api.dto.CreateLicenseRequestDto;
import org.example.api.dto.UpdateLicenseRequestDto;
import org.example.core.exception.LicenseAlreadyExistException;
import org.example.core.exception.LicenseDoesNotExistException;
import org.example.core.model.License;
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

    public License createLicense(CreateLicenseRequestDto requestDto) throws LicenseAlreadyExistException {
        License license = licenseProvider.findByOrganizationIdAndName(requestDto.getOrganizationId(), requestDto.getProductName());
        if (license != null)
            throw new LicenseAlreadyExistException(String.format("license %s for organization %d already exists", license.getProductName(), license.getOrganizationId()));
        license = licenseProvider.save(requestDto);
        log.info("license {} created", license.getLicenseId());
        return license;
    }

    public License getLicense(Long licenseId) throws LicenseDoesNotExistException {
        License license = licenseProvider.findByLicenseId(licenseId);
        if (license == null)
            throw new LicenseDoesNotExistException(String.format("license %d does not exist", licenseId));
//        TODO: abstract or remove this away later. Leave for demonstration for now.
        String licenseRetrieved = messageSource.getMessage("license.get.success", new Object[]{licenseId}, Locale.US);
        log.info(licenseRetrieved);
        return license;
    }

    @Transactional
    public void updateLicense(UpdateLicenseRequestDto requestDto) throws LicenseDoesNotExistException {
        License license = licenseProvider.findByLicenseId(requestDto.getLicenseId());
        if (license == null)
            throw new LicenseDoesNotExistException(String.format("license %d does not exist", requestDto.getLicenseId()));
        log.info("license {} updated with values: {}", license.getLicenseId(), requestDto);
        licenseProvider.save(requestDto);
    }

    public void deleteLicense(Long licenseId) throws LicenseDoesNotExistException {
        License license = licenseProvider.findByLicenseId(licenseId);
        if (license == null)
            throw new LicenseDoesNotExistException(String.format("license %d does not exist", licenseId));
        log.info("license {} removed", licenseId);
        licenseProvider.deleteById(licenseId);
    }
}
