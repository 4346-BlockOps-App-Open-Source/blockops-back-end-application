package com.example.blockopsbackendaplication.crypto.repository;

import com.example.blockopsbackendaplication.crypto.model.Signal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignalRepository extends JpaRepository<Signal, Long> {
}
