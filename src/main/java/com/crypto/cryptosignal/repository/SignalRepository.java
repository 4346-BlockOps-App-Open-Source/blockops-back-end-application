package com.crypto.cryptosignal.repository;

import com.crypto.cryptosignal.model.Signal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SignalRepository extends JpaRepository<Signal, Long> {
}