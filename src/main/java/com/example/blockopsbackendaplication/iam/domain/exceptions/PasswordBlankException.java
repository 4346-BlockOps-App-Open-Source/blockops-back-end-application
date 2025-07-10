package com.example.blockopsbackendaplication.iam.domain.exceptions;

public class PasswordBlankException extends RuntimeException {
    public PasswordBlankException(String message) {
        super(message);
    }
}
