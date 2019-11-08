package com.rhaxx.rhaxxauthenticationservice.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import com.rhaxx.rhaxxauthenticationservice.models.Credential;
import com.rhaxx.rhaxxauthenticationservice.repositories.CredentialRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CredentialServiceIMPL implements CredentialService {

    private CredentialRepository credentialRepository;

    @Autowired
    public CredentialServiceIMPL(CredentialRepository credentialRepository) {
        this.credentialRepository = credentialRepository;
    }

    @Transactional
    @Override
    public Credential createCredential(Credential credential) {
        if(credential != null && credential != new Credential()) {
            return credentialRepository.save(credential);
        }
        else {
            return null;
        }
    }

    @Override
    public void updateCredential(Credential credential) {

    }

    @Override
    public void deleteCredential(Credential credential) {

    }

    @Override
    public List<Credential> getAllCredential() {
        List<Credential> credentials = new ArrayList<>();
		credentialRepository.findAll().forEach(credentials::add);
		return credentials;
    }

}