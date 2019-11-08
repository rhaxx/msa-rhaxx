package com.rhaxx.rhaxxcredentialservice.services;

import java.util.List;

import com.rhaxx.rhaxxcredentialservice.models.Credential;

public interface CredentialService {

    public Credential createCredential(Credential credential);

    public void updateCredential(Credential credential);

    public void deleteCredential(Credential credential);

    // public void deleteByCredentialId(long credentialId);

    public List<Credential> getAllCredential();

}