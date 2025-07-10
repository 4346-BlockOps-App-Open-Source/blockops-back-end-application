package com.example.blockopsbackendaplication.iam.interfaces.rest.transform;

import com.example.blockopsbackendaplication.iam.domain.model.commands.SignInByEmailCommand;
import com.example.blockopsbackendaplication.iam.domain.model.commands.SignInCommand;
import com.example.blockopsbackendaplication.iam.interfaces.rest.resources.SignInEmailResource;
import com.example.blockopsbackendaplication.iam.interfaces.rest.resources.SignInResource;

public class SignInCommandFromResourceAssembler {
    public static SignInCommand toCommandFromResource(SignInResource signInResource) {
        return new SignInCommand(signInResource.username(), signInResource.password());
    }
    public static SignInByEmailCommand toCommandEmailFromResource(SignInEmailResource signinEmailResource){
        return new SignInByEmailCommand(signinEmailResource.email(),signinEmailResource.password());
    }
}