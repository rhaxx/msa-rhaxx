package com.rhaxx.rhaxxauthenticationservice.controllers;

import java.util.List;

import javax.validation.Valid;

import com.rhaxx.rhaxxauthenticationservice.models.Credential;
import com.rhaxx.rhaxxauthenticationservice.models.Player;
import com.rhaxx.rhaxxauthenticationservice.services.AuthenticationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
// @RequestMapping(value = "/authentication") // replaced by gateway
public class AuthenticationController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthenticationController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping(value = "/credential/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Credential>> getAllCredentials() {
        List<Credential> credentials = authenticationService.getAllCredentials();
        return new ResponseEntity<>(credentials, HttpStatus.OK);
    }

    @PostMapping(value = "/credential/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Credential> createCredential(@Valid @RequestBody Credential credential) {
        if (credential != null) {
            return new ResponseEntity<>(this.authenticationService.createCredential(credential), HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/credential/delete")
    public ResponseEntity<String> deleteCredential(@Valid @RequestBody Credential credential) {
        if (credential != null) {
            String response = credential.getPlayer().getName() + " was successfully deleted.";
            this.authenticationService.deleteCredential(credential);
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping(value = "/player/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Player>> getAllPlayers() {
		List<Player> players = authenticationService.getAllPlayers();
		return new ResponseEntity<>(players, HttpStatus.OK);
	}

    @PostMapping(value = "/player/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Player> createPlayer(@Valid @RequestBody Player player) {
        if(player != null) {
            return new ResponseEntity<>(this.authenticationService.createPlayer(player), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping(value = "/player/delete")
    public ResponseEntity<String> deletePlayer(@Valid @RequestBody Player player) {
        if(player != null) {
            String response = player.getName() + " was successfully deleted.";
            this.authenticationService.deletePlayer(player);
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


}