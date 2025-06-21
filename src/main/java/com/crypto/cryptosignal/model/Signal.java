package com.crypto.cryptosignal.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Table(name = "signals")
@Entity
public class Signal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cryptoName;
    private double price;
    private String recommendation;
    private LocalDateTime timestamp;

    public Signal() {}

    public Signal(String cryptoName, double price, String recommendation, LocalDateTime timestamp) {
        this.cryptoName = cryptoName;
        this.price = price;
        this.recommendation = recommendation;
        this.timestamp = timestamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCryptoName() {
        return cryptoName;
    }

    public void setCryptoName(String cryptoName) {
        this.cryptoName = cryptoName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

}