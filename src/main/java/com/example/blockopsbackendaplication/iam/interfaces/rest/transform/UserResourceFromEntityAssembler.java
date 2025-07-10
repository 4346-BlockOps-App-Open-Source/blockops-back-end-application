package com.example.blockopsbackendaplication.iam.interfaces.rest.transform;

import com.example.blockopsbackendaplication.iam.domain.model.aggregates.User;
import com.example.blockopsbackendaplication.iam.interfaces.rest.resources.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user) {
        return new UserResource(user.getId(), user.getUsername());
    }
}