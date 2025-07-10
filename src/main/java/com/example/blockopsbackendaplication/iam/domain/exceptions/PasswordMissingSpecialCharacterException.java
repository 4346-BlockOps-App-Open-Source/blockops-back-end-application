package com.example.blockopsbackendaplication.iam.domain.exceptions;

public class PasswordMissingSpecialCharacterException extends RuntimeException {
    public PasswordMissingSpecialCharacterException(String message) {
        super(message);
    }
}
