package com.rhaxx.rhaxxcredentialservice.models;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

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

}