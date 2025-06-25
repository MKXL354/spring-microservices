package org.example.api.facade;

import org.example.core.exception.LicenseAlreadyExistException;
import org.example.core.exception.LicenseDoesNotExistException;
import org.example.core.model.License;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
public interface LicenseFacade {

    String BASE_PATH = "api/v1/organization/{organizationId}/license";
    String LICENSE = "/{licenseId}";

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    License createLicense(@RequestBody License license) throws LicenseAlreadyExistException;

    @GetMapping( path = LICENSE, produces = MediaType.APPLICATION_JSON_VALUE)
    License getLicense(@PathVariable Long licenseId) throws LicenseDoesNotExistException;

    @DeleteMapping(path = LICENSE)
    void deleteLicense(@PathVariable Long licenseId) throws LicenseDoesNotExistException;

    @PatchMapping(path = LICENSE, produces = MediaType.APPLICATION_JSON_VALUE)
    void updateLicense(@RequestBody License license) throws LicenseDoesNotExistException;
}
