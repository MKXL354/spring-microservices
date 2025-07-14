package org.example.core.provider;

import org.example.api.dto.CreateLicenseRequestDto;
import org.example.api.dto.UpdateLicenseRequestDto;
import org.example.core.model.License;

/**
 * @author Mehdi Kamali
 * @since 03/07/2025
 */
public interface LicenseProvider {

    License findByLicenseId(Long licenseId);

    void deleteById(Long licenseId);

    License findByOrganizationIdAndName(Long organizationId, String name);

    License save(CreateLicenseRequestDto requestDto);

    void save(UpdateLicenseRequestDto requestDto);
}
