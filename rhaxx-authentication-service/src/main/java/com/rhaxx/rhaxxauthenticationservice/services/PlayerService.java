package com.rhaxx.rhaxxauthenticationservice.services;

import java.util.List;

import com.rhaxx.rhaxxauthenticationservice.models.Player;

public interface PlayerService {
    
    public List<Player> getAllPlayers();

    public Player createPlayer(Player player);

    public void updatePlayer(Player player);

    public void deletePlayer(Player player);

}