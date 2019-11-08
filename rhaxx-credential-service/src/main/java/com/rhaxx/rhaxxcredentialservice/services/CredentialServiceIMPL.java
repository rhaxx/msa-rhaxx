package com.rhaxx.rhaxxcredentialservice.services;

import java.util.List;

import javax.transaction.Transactional;

import com.rhaxx.rhaxxcredentialservice.models.Credential;
import com.rhaxx.rhaxxcredentialservice.repositories.CredentialRepository;

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
        return null;
    }

}