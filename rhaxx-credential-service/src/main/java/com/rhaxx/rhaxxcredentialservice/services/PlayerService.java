package com.rhaxx.rhaxxcredentialservice.services;

import java.util.List;

import com.rhaxx.rhaxxcredentialservice.models.Player;

public interface PlayerService {

    public void createPlayer(Player player);

    public void updatePlayer(Player player);

    public void deletePlayer(Player player);

    // public void deleteByPlayerId(long playerId);

    public List<Player> getAllPlayer();

}