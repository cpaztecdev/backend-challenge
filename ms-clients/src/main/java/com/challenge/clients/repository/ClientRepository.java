package com.challenge.clients.repository;

import com.challenge.clients.model.Client;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class ClientRepository {

    private final Map<Long, Client> db = new ConcurrentHashMap<>();

    public List<Client> findAll() {
        return db.values().stream().toList();
    }

    public Optional<Client> findById(Long id) {
        return Optional.ofNullable(db.get(id));
    }

    public Client save(Client client) {
        db.put(client.id(), client);
        return client; // ← esto está bien
    }
}