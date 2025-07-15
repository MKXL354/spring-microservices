package org.example.api.errorHandling;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
@Getter
@Setter
@AllArgsConstructor
public class ErrorDetail {
    private LocalDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;
}
