package org.example.repository.providerImpl;

import lombok.RequiredArgsConstructor;
import org.example.api.dto.CreateLicenseRequestDto;
import org.example.api.dto.UpdateLicenseRequestDto;
import org.example.core.exception.LicenseDoesNotExistException;
import org.example.core.model.License;
import org.example.core.model.Organization;
import org.example.core.provider.LicenseProvider;
import org.example.repository.assembler.LicenseAssembler;
import org.example.repository.entity.LicenseEntity;
import org.example.repository.jpa.LicenseJpaRepository;
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
    public License findByLicenseId(Long licenseId) throws LicenseDoesNotExistException {
        LicenseEntity licenseEntity = licenseJpaRepository.findById(licenseId).orElseThrow(() ->
                new LicenseDoesNotExistException(String.format("license %d does not exist", licenseId)));
        return licenseAssembler.toLicense(licenseEntity);
    }

    @Override
    public void deleteById(Long licenseId) {
        licenseJpaRepository.deleteById(licenseId);
    }

    @Override
    public License findByOrganizationIdAndName(Long organizationId, String name) {
        LicenseEntity licenseEntity = licenseJpaRepository.findByOrganizationIdAndName(organizationId, name);
        return licenseAssembler.toLicense(licenseEntity);
    }

    @Override
    public License save(CreateLicenseRequestDto requestDto, Organization organization) {
        LicenseEntity licenseEntity = licenseAssembler.generateLicenseEntity(requestDto, organization);
        return licenseAssembler.toLicense(licenseJpaRepository.save(licenseEntity));
    }

    @Override
    public void save(Long licenseId, UpdateLicenseRequestDto requestDto) {
        LicenseEntity licenseEntity = licenseJpaRepository.findById(licenseId).orElse(null);
        if (licenseEntity == null) {
            return;
        }
        licenseEntity.setName(requestDto.getProductName());
        licenseEntity.setDescription(requestDto.getDescription());
        licenseJpaRepository.save(licenseEntity);
    }
}
