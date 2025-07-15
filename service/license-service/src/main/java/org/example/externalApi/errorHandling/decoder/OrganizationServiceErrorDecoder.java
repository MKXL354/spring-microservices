package org.example.externalApi.errorHandling.decoder;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.codec.ErrorDecoder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.core.exception.ServiceRuntimeException;
import org.example.externalApi.errorHandling.enumeration.OrganizationServiceErrorType;
import org.example.externalApi.errorHandling.errorDto.OrganizationServiceErrorDto;
import org.example.externalApi.errorHandling.exception.ServiceOrganizationDoesNotExistException;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
@RequiredArgsConstructor
@Slf4j
public class OrganizationServiceErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper;

    @Override
    public RuntimeException decode(String methodKey, Response response) {
        try (InputStream body = response.body().asInputStream()) {
            OrganizationServiceErrorDto errorDto = objectMapper.readValue(body, OrganizationServiceErrorDto.class);
            return createErrorException(errorDto);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private RuntimeException createErrorException(OrganizationServiceErrorDto errorDto) {
        try {
            OrganizationServiceErrorType errorType = OrganizationServiceErrorType.valueOf(errorDto.getError());
            return switch (errorType) {
                case OrganizationDoesNotExistException ->
                        new ServiceOrganizationDoesNotExistException(errorDto.getMessage());
            };
        } catch (IllegalArgumentException e) {
            String fullMessage = errorDto.getError() + ": " + e.getMessage();
            log.warn("organization service error not handled: {}",  fullMessage);
            return new ServiceRuntimeException(fullMessage);
        }
    }
}
