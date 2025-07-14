package org.example.api.facade;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.example.api.dto.CreateLicenseRequestDto;
import org.example.api.dto.UpdateLicenseRequestDto;
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

    String BASE_PATH = "api/v1/license";
    String LICENSE = "/{licenseId}";

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    License createLicense(@RequestBody @Valid CreateLicenseRequestDto requestDto) throws LicenseAlreadyExistException;

    @GetMapping(path = LICENSE, produces = MediaType.APPLICATION_JSON_VALUE)
    License getLicense(@PathVariable @NotNull Long licenseId) throws LicenseDoesNotExistException;

    @DeleteMapping(path = LICENSE)
    void deleteLicense(@PathVariable @NotNull Long licenseId) throws LicenseDoesNotExistException;

    @PatchMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    void updateLicense(@RequestBody @Valid UpdateLicenseRequestDto requestDto) throws LicenseDoesNotExistException;
}
