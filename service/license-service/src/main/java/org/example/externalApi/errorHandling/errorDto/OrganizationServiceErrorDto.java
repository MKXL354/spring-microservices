package org.example.externalApi.errorHandling.errorDto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
@Getter
@Setter
public class OrganizationServiceErrorDto {

    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
