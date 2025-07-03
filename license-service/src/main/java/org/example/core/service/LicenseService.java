package org.example.core.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.core.exception.LicenseAlreadyExistException;
import org.example.core.exception.LicenseDoesNotExistException;
import org.example.core.model.License;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Locale;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class LicenseService {

    private HashMap<Long, License> licenseMap = new HashMap<>();

    private final MessageSource messageSource;

    public License createLicense(License license) throws LicenseAlreadyExistException {
        if (licenseMap.containsKey(license.getLicenseId()))
            throw new LicenseAlreadyExistException(String.format("license %d already exists", license.getLicenseId()));
        licenseMap.put(license.getLicenseId(), license);
        log.info("license {} created", license.getLicenseId());
        return license;
    }

    public License getLicense(Long licenseId) throws LicenseDoesNotExistException {
        if (!licenseMap.containsKey(licenseId))
            throw new LicenseDoesNotExistException(String.format("license %d does not exist", licenseId));
//        TODO: abstract or remove this away later. Leave for demonstration for now.
        String licenseCreated = messageSource.getMessage("license.create.success", new Object[]{licenseId}, Locale.US);
        log.info(licenseCreated);
        return licenseMap.get(licenseId);
    }

    public void updateLicense(License license) throws LicenseDoesNotExistException {
        if (!licenseMap.containsKey(license.getLicenseId()))
            throw new LicenseDoesNotExistException(String.format("license %d does not exist", license.getLicenseId()));
        log.info("license {} updated", license.getLicenseId());
        licenseMap.put(license.getLicenseId(), license);
    }

    public void deleteLicense(Long licenseId) throws LicenseDoesNotExistException {
        if (!licenseMap.containsKey(licenseId))
            throw new LicenseDoesNotExistException(String.format("license %d does not exist", licenseId));
        log.info("license {} removed", licenseId);
        licenseMap.remove(licenseId);
    }
}
