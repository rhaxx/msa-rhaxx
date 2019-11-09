package com.rhaxx.rhaxxauthenticationservice.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.rhaxx.rhaxxauthenticationservice.models.Credential;
import com.rhaxx.rhaxxauthenticationservice.models.Player;
import com.rhaxx.rhaxxauthenticationservice.repositories.CredentialRepository;
import com.rhaxx.rhaxxauthenticationservice.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceIMPL implements AuthenticationService {

    private CredentialRepository credentialRepository;
    private PlayerRepository playerRepository;

    @Autowired
    public AuthenticationServiceIMPL(CredentialRepository credentialRepository, PlayerRepository playerRepository) {
        this.credentialRepository = credentialRepository;
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Credential> getAllCredentials() {
        List<Credential> credentials = new ArrayList<>();
        credentialRepository.findAll().forEach(credentials::add);
        return credentials;
    }

    @Transactional
    @Override
    public Credential createUpdateCredential(Credential credential) {
        if (credential != null && credential != new Credential()) {
            playerRepository.save(credential.getPlayer());
            return credentialRepository.save(credential);
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void deleteCredential(Credential credential) {
        if (credential != null && credential != new Credential()) {
            playerRepository.delete(credential.getPlayer());
            credentialRepository.delete(credential);
        }
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
		playerRepository.findAll().forEach(players::add);
		return players;
    }

    @Transactional
    @Override
    public Player createUpdatePlayer(Player player) {
        if(player != null && player != new Player()) {
            return playerRepository.save(player);
        }
        else {
            return null;
        }
    }

    @Transactional
    @Override
    public void deletePlayer(Player player) {
        if (player != null && player != new Player()) {
            playerRepository.save(player);
        }
    }
    
}