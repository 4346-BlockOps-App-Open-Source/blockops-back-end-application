package com.example.blockopsbackendaplication.iam.domain.exceptions;

public class PasswordTooShortException extends RuntimeException {
    public PasswordTooShortException(String message) {
        super(message);
    }
}
