package com.rhaxx.rhaxxcredentialservice.repositories;

import com.rhaxx.rhaxxcredentialservice.models.Credential;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CredentialRepository extends JpaRepository<Credential, Long> {

}