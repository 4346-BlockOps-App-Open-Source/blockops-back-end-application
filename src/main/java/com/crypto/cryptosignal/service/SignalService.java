package com.crypto.cryptosignal.service;

import com.crypto.cryptosignal.model.Signal;
import com.crypto.cryptosignal.repository.SignalRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class SignalService {

    private final SignalRepository repository;

    public SignalService(SignalRepository repository) {
        this.repository = repository;
    }

    public List<Signal> getAllSignals() {
        return repository.findAll();
    }

    public Signal createSignal(String cryptoName, double newPrice, double oldPrice) {
        String recommendation = newPrice > oldPrice ? "BUY" : "SELL";
        Signal signal = new Signal(cryptoName, newPrice, recommendation, LocalDateTime.now());
        return repository.save(signal);
    }

}
