package com.example.blockopsbackendaplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.example.blockopsbackendaplication")
public class BlockopsBackendAplicationApplication {
    public static void main(String[] args) {
        SpringApplication.run(BlockopsBackendAplicationApplication.class, args);
    }
}

}
