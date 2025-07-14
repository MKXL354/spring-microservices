package org.example.repository;

import org.example.repository.entity.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mehdi Kamali
 * @since 14/07/2025
 */
@Repository
public interface OrganizationJpaRepository extends JpaRepository<Organization,Long> {

    Organization findByName(String name);
}
