package com.example.blockopsbackendaplication.educacionfinanciera.infrastructure.repository;

import com.example.blockopsbackendaplication.educacionfinanciera.domain.model.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {
}
