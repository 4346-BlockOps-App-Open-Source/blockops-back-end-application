package com.crypto.cryptosignal.controller;

import com.crypto.cryptosignal.model.Signal;
import com.crypto.cryptosignal.service.SignalService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/signals")
public class SignalController {

    private final SignalService service;

    public SignalController(SignalService service) {
        this.service = service;
    }

    @GetMapping
    public List<Signal> getSignals() {
        return service.getAllSignals();
    }

    @PostMapping
    public Signal createSignal(@RequestParam String cryptoName,
                               @RequestParam double newPrice,
                               @RequestParam double oldPrice) {
        return service.createSignal(cryptoName, newPrice, oldPrice);
    }

}
