package org.example.api.errorHandling;

import jakarta.servlet.http.HttpServletRequest;
import org.example.core.exception.LicenseDoesNotExistException;
import org.example.core.exception.OrganizationDoesNotHaveAccessToLicenseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
@RestControllerAdvice
public class GlobalRestErrorHandler {

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ErrorDetail handleException(Exception ex, HttpServletRequest request) {
        return new ErrorDetail(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), Exception.class.getSimpleName(),
                "Internal Server Error", request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String message = ex.getBindingResult().getFieldErrors().stream().map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining("\n"));
        return new ErrorDetail(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), MethodArgumentNotValidException.class.getSimpleName(),
                message, request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(LicenseDoesNotExistException.class)
    public ErrorDetail handleLicenseDoesNotExistException(LicenseDoesNotExistException ex, HttpServletRequest request) {
        return new ErrorDetail(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), LicenseDoesNotExistException.class.getSimpleName(),
                ex.getMessage(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(OrganizationDoesNotHaveAccessToLicenseException.class)
    public ErrorDetail handleOrganizationDoesNotHaveAccessToLicenseException(OrganizationDoesNotHaveAccessToLicenseException ex, HttpServletRequest request) {
        return new ErrorDetail(LocalDateTime.now(), HttpStatus.UNAUTHORIZED.value(), OrganizationDoesNotHaveAccessToLicenseException.class.getSimpleName(),
                ex.getMessage(), request.getRequestURI());
    }
}
