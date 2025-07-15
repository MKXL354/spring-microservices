package org.example.api.facade;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.example.api.dto.CreateLicenseRequestDto;
import org.example.api.dto.UpdateLicenseRequestDto;
import org.example.core.exception.LicenseDoesNotExistException;
import org.example.core.exception.OrganizationDoesNotHaveAccessToLicenseException;
import org.example.core.model.License;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
public interface LicenseFacade {

    String BASE_PATH = "api/v1/organization/{organizationId}/license";
    String LICENSE = BASE_PATH + "/{licenseId}";

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    License createLicense(@NotNull @PathVariable Long organizationId, @Valid @RequestBody CreateLicenseRequestDto requestDto);

    @GetMapping(path = LICENSE, produces = MediaType.APPLICATION_JSON_VALUE)
    License getLicense(@NotNull @PathVariable Long organizationId, @NotNull @PathVariable Long licenseId) throws LicenseDoesNotExistException,
            OrganizationDoesNotHaveAccessToLicenseException;

    @DeleteMapping(path = LICENSE)
    void deleteLicense(@NotNull @PathVariable Long organizationId, @NotNull @PathVariable Long licenseId) throws LicenseDoesNotExistException,
            OrganizationDoesNotHaveAccessToLicenseException;

    @PatchMapping(path = LICENSE, consumes = MediaType.APPLICATION_JSON_VALUE)
    void updateLicense(@NotNull @PathVariable Long organizationId, @NotNull @PathVariable Long licenseId, @Valid @RequestBody UpdateLicenseRequestDto requestDto)
            throws LicenseDoesNotExistException, OrganizationDoesNotHaveAccessToLicenseException;
}
