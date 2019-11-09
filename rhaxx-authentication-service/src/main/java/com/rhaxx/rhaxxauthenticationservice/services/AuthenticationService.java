package com.rhaxx.rhaxxauthenticationservice.services;

import java.util.List;

import com.rhaxx.rhaxxauthenticationservice.models.Credential;
import com.rhaxx.rhaxxauthenticationservice.models.Player;

public interface AuthenticationService {

    public List<Credential> getAllCredentials();

    public Credential createUpdateCredential(Credential credential);

    public void deleteCredential(Credential credential);

    public List<Player> getAllPlayers();

    public Player createUpdatePlayer(Player player);

    public void deletePlayer(Player player);
    
}