package com.example.blockopsbackendaplication.iam.infrastructure.hashing.bcrypt;


import com.example.blockopsbackendaplication.iam.application.internal.outboundservices.hashing.HashingService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface BCryptHashingService extends HashingService, PasswordEncoder {
}