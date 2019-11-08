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

    @Override
    public List<Credential> getAllCredentials() {
        List<Credential> credentials = new ArrayList<>();
        credentialRepository.findAll().forEach(credentials::add);
        return credentials;
    }

    @Transactional
    @Override
    public Credential createCredential(Credential credential) {
        if (credential != null && credential != new Credential()) {
            return credentialRepository.save(credential);
        } else {
            return null;
        }
    }

    @Transactional
    @Override
    public void updateCredential(Credential credential) {
        if (credential != null && credential != new Credential()) {
            credentialRepository.save(credential);
        }
    }

    @Transactional
    @Override
    public void deleteCredential(Credential credential) {
        if (credential != null && credential != new Credential()) {
            credentialRepository.delete(credential);
        }
    }

}