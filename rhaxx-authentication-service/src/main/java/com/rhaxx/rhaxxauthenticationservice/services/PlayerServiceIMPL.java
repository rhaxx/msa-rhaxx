package com.rhaxx.rhaxxauthenticationservice.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.rhaxx.rhaxxauthenticationservice.models.Player;
import com.rhaxx.rhaxxauthenticationservice.repositories.PlayerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PlayerServiceIMPL implements PlayerService {

    private PlayerRepository playerRepository;

    @Autowired
    public PlayerServiceIMPL(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    @Override
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
		playerRepository.findAll().forEach(players::add);
		return players;
    }

    @Transactional
    @Override
    public Player createPlayer(Player player) {
        if(player != null && player != new Player()) {
            return playerRepository.save(player);
        }
        else {
            return null;
        }
    }

    @Transactional
    @Override
    public void updatePlayer(Player player) {
        if (player != null && player != new Player()) {
            playerRepository.save(player);
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