package org.example.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import org.example.core.enumeration.LicenseType;

/**
 * @author Mehdi Kamali
 * @since 03/07/2025
 */
@Getter
@Setter
public class CreateLicenseRequestDto {

    @Size(max = 500)
    private String description;

    @NotNull
    private Long organizationId;

    @Size(max = 100)
    private String productName;

    @NotNull
    private LicenseType licenseType;
}
