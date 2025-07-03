package org.example.repository.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.repository.enumeration.LicenseType;

/**
 * @author Mehdi Kamali
 * @since 03/07/2025
 */
@Entity
@Table(name = "LICENSE")
@Getter
@Setter
public class License {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", columnDefinition = "BIGINT", unique = true)
    private Long id;

    @Column(name = "DESCRIPTION", columnDefinition = "VARCHAR(500)")
    private String description;

    @Column(name = "ORGANIZATION_ID", columnDefinition = "BIGINT", nullable = false)
    private Long organizationId;

    @Column(name = "NAME", columnDefinition = "VARCHAR(100)", nullable = false)
    private String name;

    @Column(name = "TYPE", columnDefinition = "VARCHAR(25)", nullable = false)
    private LicenseType licenseType;
}
