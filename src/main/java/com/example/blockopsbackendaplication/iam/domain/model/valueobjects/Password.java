package com.example.blockopsbackendaplication.iam.domain.model.valueobjects;


import com.example.blockopsbackendaplication.iam.domain.exceptions.*;
import jakarta.persistence.Embeddable;

@Embeddable
public record Password(String password) {
    public Password {
        if (password == null || password.isBlank()) {
            throw new PasswordBlankException(password);
        }
        if (password.length() < 8) {
            throw new PasswordTooShortException( password );
        }
        if (!password.matches(".*[A-Z].*")) {
            throw new PasswordMissingUppercaseException(password);
        }
        if (!password.matches(".*[a-z].*")) {
            throw new PasswordMissingLowercaseException( password );
        }
        if (!password.matches(".*\\d.*")) {
            throw new PasswordMissingNumberException( password );
        }
        if (!password.matches(".*[^a-zA-Z0-9].*")) {
            throw new PasswordMissingSpecialCharacterException( password );
        }
    }
}