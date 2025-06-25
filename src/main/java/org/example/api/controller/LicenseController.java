package org.example.api.controller;

import org.example.api.facade.LicenseFacade;
import org.example.core.model.License;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
@RestController
@RequestMapping(LicenseFacade.BASE_PATH)
public class LicenseController implements LicenseFacade {

    public License createLicense(License license) {
        return null;
    }

    public License getLicense(Long licenseId) {
        return null;
    }

    public void deleteLicense(Long licenseId) {

    }

    public void updateLicense(License license) {

    }
}
