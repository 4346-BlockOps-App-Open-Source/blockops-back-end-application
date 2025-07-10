package com.example.blockopsbackendaplication.iam.domain.model.valueobjects;

import com.example.blockopsbackendaplication.iam.domain.exceptions.EmailAddressBlankException;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Email;

@Embeddable
public record EmailAddress(@Email String value) {
    public EmailAddress(){this(null);}
    public EmailAddress{
        if(value==null||value.isBlank()){
            throw new EmailAddressBlankException(value);
        }
    }
}
