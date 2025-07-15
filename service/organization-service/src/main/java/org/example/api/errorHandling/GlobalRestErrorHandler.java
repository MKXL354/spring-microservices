package org.example.api.errorHandling;

import jakarta.servlet.http.HttpServletRequest;
import org.example.api.exception.OrganizationAlreadyExistException;
import org.example.api.exception.OrganizationDoesNotExistException;
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
//TODO: do custom business oriented error codes
@RestControllerAdvice
public class GlobalRestErrorHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(OrganizationDoesNotExistException.class)
    public ErrorDetail handleOrganizationDoesNotExistException(OrganizationDoesNotExistException ex, HttpServletRequest request) {
        return new ErrorDetail(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), OrganizationDoesNotExistException.class.getSimpleName(),
                ex.getMessage(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler(OrganizationAlreadyExistException.class)
    public ErrorDetail handleOrganizationAlreadyExistException(OrganizationAlreadyExistException ex, HttpServletRequest request) {
        return new ErrorDetail(LocalDateTime.now(), HttpStatus.CONFLICT.value(), OrganizationAlreadyExistException.class.getSimpleName(),
                ex.getMessage(), request.getRequestURI());
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDetail handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request) {
        String message = ex.getBindingResult().getFieldErrors().stream().map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining("\n"));
        return new ErrorDetail(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), MethodArgumentNotValidException.class.getSimpleName(),
                message, request.getRequestURI());
    }
}
