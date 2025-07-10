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
        Server railway = new Server();
        railway.setUrl("https://blockops-back-end-application-production.up.railway.app");
        railway.setDescription("Railway Production");

        Server local = new Server();
        local.setUrl("http://localhost:8080");
        local.setDescription("Localhost");

        return new OpenAPI().servers(List.of(railway, local));
    }
}
