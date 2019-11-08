package com.rhaxx.rhaxxcredentialservice.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CREDENTIAL")
public class Credential {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CREDENTIAL_ID_SEQ")
    @SequenceGenerator(name = "CREDENTIAL_ID_SEQ", sequenceName = "CREDENTIAL_ID_SEQ", allocationSize = 1, initialValue = 1)
    @Column(name = "CREDENTIAL_ID")
    private long credentialId;
    @Column(name = "CREDENTIAL_USERNAME")
    private String username;
    @Column(name = "CREDENTIAL_PASSWORD")
    private String password;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "PLAYER_ID")
    Player player;

}