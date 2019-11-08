package com.rhaxx.rhaxxauthenticationservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PLAYER")
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PLAYER_ID_SEQ")
    @SequenceGenerator(name = "PLAYER_ID_SEQ", sequenceName = "PLAYER_ID_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "PLAYER_ID")
    private long playerId;
    @Column(name = "PLAYER_NAME")
    private String name;
    @Column(name = "PLAYER_EMAIL")
    private String email;
    @Column(name = "PLAYER_BALANCE")
    private double balance;

    public long getPlayerId() {
        return this.playerId;
    }

    public void setPlayerId(long playerId) {
        this.playerId = playerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getBalance() {
        return this.balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}