package com.example.blockopsbackendaplication.iam.application.internal.commandservices;

import com.example.blockopsbackendaplication.iam.application.internal.outboundservices.hashing.HashingService;
import com.example.blockopsbackendaplication.iam.application.internal.outboundservices.tokens.TokenService;
import com.example.blockopsbackendaplication.iam.domain.model.aggregates.User;
import com.example.blockopsbackendaplication.iam.domain.model.commands.SignInByEmailCommand;
import com.example.blockopsbackendaplication.iam.domain.model.commands.SignInCommand;
import com.example.blockopsbackendaplication.iam.domain.model.commands.SignUpCommand;
import com.example.blockopsbackendaplication.iam.domain.model.valueobjects.EmailAddress;
import com.example.blockopsbackendaplication.iam.domain.services.UserCommandService;
import com.example.blockopsbackendaplication.iam.infrastructure.persistence.jpa.repositories.UserRepository;
import org.apache.commons.lang3.tuple.ImmutablePair;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    private final UserRepository userRepository;
    private final HashingService hashingService;
    private final TokenService tokenService;

    public UserCommandServiceImpl(UserRepository userRepository, HashingService hashingService, TokenService tokenService) {
        this.userRepository = userRepository;
        this.hashingService = hashingService;
        this.tokenService = tokenService;

    }

    /**
     * Handle the sign-in command
     * <p>
     *     This method handles the {@link SignInCommand} command and returns the user and the token.
     * </p>
     * @param command the sign-in command containing the username and password
     * @return and optional containing the user matching the username and the generated token
     * @throws RuntimeException if the user is not found or the password is invalid
     */
    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInCommand command) {
        var user = userRepository.findByUsername(command.username());
        if (user.isEmpty())
            throw new RuntimeException("User not found");
        if (!hashingService.matches(command.password(), user.get().getPassword().password()))
            throw new RuntimeException("Invalid password");
        var token = tokenService.generateToken(user.get().getUsername());
        return Optional.of(ImmutablePair.of(user.get(), token));
    }

    @Override
    public Optional<ImmutablePair<User, String>> handle(SignInByEmailCommand command) {
        var email = new EmailAddress(command.email());
        var user = userRepository.findByEmailAddress(email);
        if(user.isEmpty()){
            throw new IllegalArgumentException("email not found ");
        }
        if(!hashingService.matches(command.password(), user.get().getPassword().password())){
            throw new IllegalArgumentException("invalid password");
        }
        var token=tokenService.generateToken(user.get().getStringEmail());
        return Optional.of(ImmutablePair.of(user.get(),token));
    }
    /**
     * Handle the sign-up command
     * <p>
     *     This method handles the {@link SignUpCommand} command and returns the user.
     * </p>
     * @param command the sign-up command containing the username and password
     * @return the created user
     */
    @Override
    public Optional<User> handle(SignUpCommand command) {
        var email= new EmailAddress(command.email());
        if (userRepository.existsByUsername(command.username())||userRepository.existsByEmailAddress(email))
            throw new RuntimeException("Username already exists or email alredy exist");
        if (command.perfilRiesgo() == null || command.preferencias() == null) {
            throw new RuntimeException("Faltan campos de perfil de riesgo o preferencias.");
        }
        // Validar valores válidos
        var perfilesValidos = java.util.List.of("Conservador","Moderado","Agresivo");
        var preferenciasValidas = java.util.List.of("Cripto","Acciones","Bonos","Forex");
        if (!perfilesValidos.contains(command.perfilRiesgo())) {
            throw new RuntimeException("Perfil de riesgo inválido. Solo: Conservador, Moderado, Agresivo");
        }
        if (!preferenciasValidas.contains(command.preferencias())) {
            throw new RuntimeException("Preferencia inválida. Solo: Cripto, Acciones, Bonos, Forex");
        }
        var user = new User(command.username(), command.firstName(), command.lastName(), command.email(), hashingService.encode(command.password()), command.perfilRiesgo(), command.preferencias());
        userRepository.save(user);
        return userRepository.findByUsername(command.username());
    }

}