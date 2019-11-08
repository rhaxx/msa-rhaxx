package com.rhaxx.rhaxxauthenticationservice.repositories;

import com.rhaxx.rhaxxauthenticationservice.models.Credential;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {

}