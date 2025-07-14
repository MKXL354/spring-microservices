package org.example.api.dto;

import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Mehdi Kamali
 * @since 14/07/2025
 */
@Getter
@Setter
public class UpdateOrganizationRequestDto {

    @Size(max = 500)
    private String description;
}
