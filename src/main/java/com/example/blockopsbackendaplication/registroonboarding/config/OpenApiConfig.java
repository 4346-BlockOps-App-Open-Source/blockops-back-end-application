package com.example.blockopsbackendaplication.registroonboarding.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.servers.Server;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        Server server = new Server();
        server.setUrl("https://blockops-back-end-application-production.up.railway.app");
        server.setDescription("Railway Production Server");
        return new OpenAPI().servers(List.of(server));
    }
}
