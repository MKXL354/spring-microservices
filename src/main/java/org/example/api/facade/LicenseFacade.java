package org.example.api.facade;

import org.example.core.model.License;
import org.springframework.web.bind.annotation.*;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
public interface LicenseFacade {

    String BASE_PATH = "v1/organization/{organizationId}/license";
    String LICENSE = "/{licenseId}";

    @PostMapping()
    License createLicense(@RequestBody License license);

    @GetMapping(LICENSE)
    License getLicense(@PathVariable Long licenseId);

    @DeleteMapping(LICENSE)
    void deleteLicense(@PathVariable Long licenseId);

    @PatchMapping(LICENSE)
    void updateLicense(@RequestBody License license);
}
