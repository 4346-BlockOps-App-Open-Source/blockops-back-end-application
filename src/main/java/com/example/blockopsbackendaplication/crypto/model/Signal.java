package com.example.blockopsbackendaplication.crypto.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "crypto_signal")
public class Signal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cryptoName;
    private double newPrice;
    private double oldPrice;
    private String signalType;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getCryptoName() { return cryptoName; }
    public void setCryptoName(String cryptoName) { this.cryptoName = cryptoName; }

    public double getNewPrice() { return newPrice; }
    public void setNewPrice(double newPrice) { this.newPrice = newPrice; }

    public double getOldPrice() { return oldPrice; }
    public void setOldPrice(double oldPrice) { this.oldPrice = oldPrice; }

    public String getSignalType() { return signalType; }
    public void setSignalType(String signalType) { this.signalType = signalType; }
}
