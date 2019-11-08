package com.rhaxx.rhaxxcredentialservice.controllers;

import javax.validation.Valid;

import com.rhaxx.rhaxxcredentialservice.models.Player;
import com.rhaxx.rhaxxcredentialservice.services.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        if(player != null) {
            return new ResponseEntity<>(this.playerService.createPlayer(player), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}