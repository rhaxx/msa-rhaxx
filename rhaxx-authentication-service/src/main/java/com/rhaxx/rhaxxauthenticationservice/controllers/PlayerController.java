package com.rhaxx.rhaxxauthenticationservice.controllers;

import java.util.List;

import javax.validation.Valid;

import com.rhaxx.rhaxxauthenticationservice.models.Player;
import com.rhaxx.rhaxxauthenticationservice.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/player")
public class PlayerController {

    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> getAllPlayers() {
		List<Player> players = playerService.getAllPlayers();
		return new ResponseEntity<>(players, HttpStatus.OK);
	}

    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        if(player != null) {
            return new ResponseEntity<>(this.playerService.createPlayer(player), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}