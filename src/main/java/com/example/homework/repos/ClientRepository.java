package com.example.homework.repos;

import com.example.homework.models.Client;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ClientRepository extends CrudRepository<Client, Long> {

    Optional<Client> findByApplicationKey(String applicationKey);
}
