package com.example.blockopsbackendaplication.iam.domain.exceptions;

public class FirstNameBlankException extends RuntimeException {
    public FirstNameBlankException(String message) {
        super(message);
    }
}
