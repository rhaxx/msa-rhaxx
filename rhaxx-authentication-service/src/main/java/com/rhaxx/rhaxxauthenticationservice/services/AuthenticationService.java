package com.rhaxx.rhaxxauthenticationservice.services;

import java.util.List;

import com.rhaxx.rhaxxauthenticationservice.models.Credential;
import com.rhaxx.rhaxxauthenticationservice.models.Player;

public interface AuthenticationService {

    public List<Credential> getAllCredentials();

    public Credential getCredentialById(long credentialId);

    public Credential createCredential(Credential credential);

    public void updateCredential(Credential credential);

    public void deleteCredential(Credential credential);

    public List<Player> getAllPlayers();

    public Player getPlayerById(long playerId);

    public Player createPlayer(Player player);

    public void updatePlayer(Player player);

    public void deletePlayer(Player player);
    
}