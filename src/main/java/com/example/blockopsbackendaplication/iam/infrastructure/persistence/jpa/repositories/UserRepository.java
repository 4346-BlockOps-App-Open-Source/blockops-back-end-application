package com.example.blockopsbackendaplication.iam.infrastructure.persistence.jpa.repositories;

import com.example.blockopsbackendaplication.iam.domain.model.aggregates.User;
import com.example.blockopsbackendaplication.iam.domain.model.valueobjects.EmailAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    boolean existsByUsername (String username);
    Optional<User>findByEmailAddress( EmailAddress emailAddress);
    boolean existsByEmailAddress(EmailAddress emailAddress);

}
