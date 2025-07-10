package com.example.blockopsbackendaplication.iam.interfaces.rest.transform;

import com.example.blockopsbackendaplication.iam.domain.model.commands.SignUpCommand;
import com.example.blockopsbackendaplication.iam.interfaces.rest.resources.SignUpResource;

public class SignUpCommandFromResourceAssembler {
    public static SignUpCommand toCommandFromResource(SignUpResource resource) {
        return new SignUpCommand(resource.username(), resource.firstName(),resource.lastName(), resource.email(), resource.password());
    }

}