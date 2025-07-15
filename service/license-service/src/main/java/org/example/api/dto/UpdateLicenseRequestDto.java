package org.example.api.dto;

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

    @Size(max = 100)
    private String productName;

    @Size(max = 500)
    private String description;
}
