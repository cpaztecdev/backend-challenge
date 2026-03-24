package com.challenge.clients.service;

import com.challenge.clients.model.Client;
import com.challenge.clients.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository repository;

    public List<Client> getAll() {
        return repository.findAll()
                .stream()
                .filter(c -> c.email().contains("@"))
                .toList();
    }

    public Client getById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Client not found"));
    }

    public Client save(Client client) {
        return repository.save(client); // ← NO debe retornar null
    }
}
