package com.example.blockopsbackendaplication.crypto.service;

import com.example.blockopsbackendaplication.crypto.model.Signal;
import com.example.blockopsbackendaplication.crypto.repository.SignalRepository;
import org.springframework.stereotype.Service;

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
        Signal signal = new Signal();
        signal.setCryptoName(cryptoName);
        signal.setNewPrice(newPrice);
        signal.setOldPrice(oldPrice);
        signal.setSignalType(newPrice > oldPrice ? "BUY" : "SELL");
        return repository.save(signal);
    }
}
