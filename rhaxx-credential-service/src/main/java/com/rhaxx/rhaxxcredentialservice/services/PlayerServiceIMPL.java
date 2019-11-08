package com.rhaxx.rhaxxcredentialservice.services;

import java.util.List;

import com.rhaxx.rhaxxcredentialservice.models.Player;
import com.rhaxx.rhaxxcredentialservice.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;

public class PlayerServiceIMPL implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceIMPL(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public Player createPlayer(Player player) {
        if(player != null && player != new Player()) {
            return playerRepository.save(player);
        }
        else {
            return null;
        }
    }

    @Override
    public void updatePlayer(Player player) {
        // TODO Auto-generated method stub

    }

    @Override
    public void deletePlayer(Player player) {
        // TODO Auto-generated method stub

    }

    @Override
    public List<Player> getAllPlayer() {
        // TODO Auto-generated method stub
        return null;
    }
    
}