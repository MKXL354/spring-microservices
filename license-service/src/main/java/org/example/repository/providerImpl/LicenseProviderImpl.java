package org.example.repository.providerImpl;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.CreateLicenseRequestDto;
import org.example.api.dto.UpdateLicenseRequestDto;
import org.example.core.model.License;
import org.example.core.provider.LicenseProvider;
import org.example.repository.LicenseJpaRepository;
import org.example.repository.assembler.LicenseAssembler;
import org.springframework.stereotype.Component;

/**
 * @author Mehdi Kamali
 * @since 03/07/2025
 */
@Component
@RequiredArgsConstructor
public class LicenseProviderImpl implements LicenseProvider {

    private final LicenseJpaRepository licenseJpaRepository;
    private final LicenseAssembler licenseAssembler;

    @Override
    public License findByLicenseId(Long licenseId) {
        org.example.repository.entity.License license = licenseJpaRepository.findById(licenseId).orElse(null);
        return licenseAssembler.toLicense(license);
    }

    @Override
    public void deleteById(Long licenseId) {
        licenseJpaRepository.deleteById(licenseId);
    }

    @Override
    public License findByOrganizationIdAndName(Long organizationId, String name) {
        org.example.repository.entity.License license = licenseJpaRepository.findByOrganizationIdAndName(organizationId, name);
        return licenseAssembler.toLicense(license);
    }

    @Override
    public License save(CreateLicenseRequestDto requestDto) {
        org.example.repository.entity.License license = licenseAssembler.generateLicenseEntity(requestDto);
        return licenseAssembler.toLicense(licenseJpaRepository.save(license));
    }

    @Override
    public void save(UpdateLicenseRequestDto requestDto) {
        org.example.repository.entity.License license = licenseJpaRepository.findById(requestDto.getLicenseId()).orElse(null);
        if (license == null) {
            return;
        }
        license.setName(requestDto.getProductName());
        license.setDescription(requestDto.getDescription());
        licenseJpaRepository.save(license);
    }
}
