package com.example.blockopsbackendaplication.iam.domain.exceptions;

public class PasswordMissingNumberException extends RuntimeException {
    public PasswordMissingNumberException(String message) {
        super(message);
    }
}
