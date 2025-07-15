package org.example.repository.assembler;

import org.example.api.dto.CreateLicenseRequestDto;
import org.example.core.enumeration.LicenseType;
import org.example.core.model.License;
import org.example.core.model.Organization;
import org.example.repository.entity.LicenseEntity;
import org.springframework.stereotype.Component;

/**
 * @author Mehdi Kamali
 * @since 03/07/2025
 */
@Component
public class LicenseAssembler {

    public License toLicense(LicenseEntity licenseEntity) {
        if (licenseEntity == null) {
            return null;
        }
        License license = new License();
        license.setLicenseId(licenseEntity.getId());
        license.setDescription(licenseEntity.getDescription());
        license.setOrganizationId(licenseEntity.getOrganizationId());
        license.setProductName(licenseEntity.getName());
        license.setLicenseType(toLicenseType(licenseEntity.getLicenseType()));
        return license;
    }

    public LicenseEntity toLicenseEntity(License license) {
        if (license == null) {
            return null;
        }
        LicenseEntity licenseEntity = new LicenseEntity();
        licenseEntity.setId(license.getLicenseId());
        licenseEntity.setDescription(license.getDescription());
        licenseEntity.setOrganizationId(license.getOrganizationId());
        licenseEntity.setName(license.getProductName());
        licenseEntity.setLicenseType(toPersistenceLicenseType(license.getLicenseType()));
        return licenseEntity;
    }

    public LicenseEntity generateLicenseEntity(CreateLicenseRequestDto requestDto, Organization organization) {
        LicenseEntity licenseEntity = new LicenseEntity();
        licenseEntity.setDescription(requestDto.getDescription());
        licenseEntity.setOrganizationId(organization.getOrganizationId());
        licenseEntity.setName(requestDto.getName());
        licenseEntity.setLicenseType(toPersistenceLicenseType(requestDto.getLicenseType()));
        return licenseEntity;
    }

    public LicenseType toLicenseType(org.example.repository.enumeration.LicenseType  licenseType) {
        return switch(licenseType) {
            case null -> null;
            case TYPE1 -> LicenseType.TYPE1;
            case TYPE2 -> LicenseType.TYPE2;
        };
    }

    public org.example.repository.enumeration.LicenseType toPersistenceLicenseType(LicenseType licenseType) {
        return switch (licenseType) {
            case null -> null;
            case TYPE1 -> org.example.repository.enumeration.LicenseType.TYPE1;
            case TYPE2 -> org.example.repository.enumeration.LicenseType.TYPE2;
        };
    }
}
