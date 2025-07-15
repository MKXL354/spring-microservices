package org.example.externalApi.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import feign.codec.ErrorDecoder;
import org.example.externalApi.errorHandling.decoder.OrganizationServiceErrorDecoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Mehdi Kamali
 * @since 15/07/2025
 */
@Configuration
public class OrganizationServiceClientConfig {

    @Bean
    public ErrorDecoder errorDecoder(ObjectMapper objectMapper) {
        return new OrganizationServiceErrorDecoder(objectMapper);
    }
}
