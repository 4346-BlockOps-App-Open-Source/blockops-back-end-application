package com.example.blockopsbackendaplication.iam.interfaces.rest.transform;

import com.example.blockopsbackendaplication.iam.domain.model.aggregates.User;
import com.example.blockopsbackendaplication.iam.interfaces.rest.resources.AuthenticatedUserByEmailResource;

public class AuthenticateUserByEmailResourceFromEntityAssembler {
    public static AuthenticatedUserByEmailResource toResourceFromEntity(User user, String token){
        return new AuthenticatedUserByEmailResource(user.getId(),user.getEmailAddress().value(),token);
    }
}
