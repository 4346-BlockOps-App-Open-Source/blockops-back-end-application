package com.example.blockopsbackendaplication.iam.domain.model.valueobjects;

import com.example.blockopsbackendaplication.iam.domain.exceptions.FirstNameBlankException;
import com.example.blockopsbackendaplication.iam.domain.exceptions.LastNameBlankException;
import jakarta.persistence.Embeddable;

@Embeddable
public record PersonName(String firstName, String lastName) {
    public PersonName(){this(null, null);}
    public PersonName {
        if (firstName == null || firstName.isBlank()) {
            throw new FirstNameBlankException(firstName);}
        if (lastName == null || lastName.isBlank()) {
            throw new LastNameBlankException(lastName);
        }

    }

    public  String getFullName() {return "%s,%s".formatted(firstName,lastName);}

}
