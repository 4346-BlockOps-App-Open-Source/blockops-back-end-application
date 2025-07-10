package com.example.blockopsbackendaplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BlockopsBackendAplicationApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlockopsBackendAplicationApplication.class, args);
    }
}
