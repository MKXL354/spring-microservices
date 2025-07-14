package org.example.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mehdi Kamali
 * @since 14/07/2025
 */
@Getter
@Setter
public class CreateOrganizationRequestDto {

    @Size(max = 500)
    private String description;

    @NotBlank
    @Size(max = 100)
    private String name;
}
