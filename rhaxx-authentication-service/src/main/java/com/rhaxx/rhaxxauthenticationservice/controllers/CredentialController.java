package com.rhaxx.rhaxxauthenticationservice.controllers;

import java.util.List;

import javax.validation.Valid;

import com.rhaxx.rhaxxauthenticationservice.models.Credential;
import com.rhaxx.rhaxxauthenticationservice.services.CredentialService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "/credential")
public class CredentialController {

    private CredentialService credentialService;

    @Autowired
    public CredentialController(CredentialService credentialService) {
        this.credentialService = credentialService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Credential>> getAllCredentials() {
		List<Credential> credentials = credentialService.getAllCredentials();
		return new ResponseEntity<>(credentials, HttpStatus.OK);
	}

    public ResponseEntity<Credential> createPlayer(@Valid @RequestBody Credential credential) {
        if(credential != null) {
            return new ResponseEntity<>(this.credentialService.createCredential(credential), HttpStatus.CREATED);
        }
        else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

}