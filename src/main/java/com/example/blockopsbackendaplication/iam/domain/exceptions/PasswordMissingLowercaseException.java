package com.example.blockopsbackendaplication.iam.domain.exceptions;

public class PasswordMissingLowercaseException extends RuntimeException {
    public PasswordMissingLowercaseException(String message) {
        super(message);
    }
}
