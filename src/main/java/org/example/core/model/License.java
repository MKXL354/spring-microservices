package org.example.core.model;

import lombok.Data;
import org.example.core.enumeration.LicenseType;

/**
 * @author Mehdi Kamali
 * @since 25/06/2025
 */
@Data
public class License {

    private Long licenseId;
    private String description;
    private Long organizationId;
    private String productName;
    private LicenseType licenseType;
}
