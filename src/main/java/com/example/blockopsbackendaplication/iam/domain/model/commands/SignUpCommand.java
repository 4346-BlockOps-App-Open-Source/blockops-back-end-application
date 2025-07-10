package com.example.blockopsbackendaplication.iam.domain.model.commands;

public record SignUpCommand(String username, String firstName, String lastName,String email, String password) {
}
