package com.example.blockopsbackendaplication.iam.domain.exceptions;

public class PasswordMissingUppercaseException extends RuntimeException {
    public PasswordMissingUppercaseException(String message) {
        super(message);
    }
}
