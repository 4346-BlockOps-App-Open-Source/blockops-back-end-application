package com.example.blockopsbackendaplication.iam.interfaces.rest.resources;

public record AuthenticatedUserByEmailResource(Long id, String email, String token) {
}
