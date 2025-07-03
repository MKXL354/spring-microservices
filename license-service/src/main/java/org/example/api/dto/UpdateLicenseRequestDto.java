package org.example.api.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mehdi Kamali
 * @since 03/07/2025
 */
@Getter
@Setter
public class UpdateLicenseRequestDto {

    @NotNull
    private Long licenseId;

    @Size(max = 100)
    private String productName;

    @Size(max = 500)
    private String description;
}
