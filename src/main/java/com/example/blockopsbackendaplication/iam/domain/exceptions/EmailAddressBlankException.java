package com.example.blockopsbackendaplication.iam.domain.exceptions;

public class EmailAddressBlankException extends RuntimeException {
    public EmailAddressBlankException(String email) {
        super(
                String.format("Email %s is blank", email)
        );
    }
}
