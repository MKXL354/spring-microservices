package org.example.repository;

import org.example.repository.entity.LicenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mehdi Kamali
 * @since 03/07/2025
 */
@Repository
public interface LicenseJpaRepository extends JpaRepository<LicenseEntity, Long> {

    LicenseEntity findByOrganizationIdAndName(Long organizationId, String name);
}
