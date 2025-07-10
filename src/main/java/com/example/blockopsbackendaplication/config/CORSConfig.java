package com.example.blockopsbackendaplication.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CORSConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // CONFIGURACIÓN TEMPORAL PARA PRUEBAS: permite cualquier origen. No usar en producción.
        registry.addMapping("/**")
            .allowedOrigins("*") // Cambiar "*" por urls específicas antes de subir a producción
            .allowedMethods("GET", "POST", "PUT", "DELETE", "PATCH", "OPTIONS")
            .allowedHeaders("*")
            .allowCredentials(true);
    }
}
