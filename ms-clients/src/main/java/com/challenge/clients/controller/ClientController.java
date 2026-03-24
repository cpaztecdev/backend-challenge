package com.challenge.clients.controller;

import com.challenge.clients.model.Client;
import com.challenge.clients.service.ClientService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/clients")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @GetMapping
    public Flux<Client> getAll() {
        return Flux.fromIterable(service.getAll());
    }

    @GetMapping("/{id}")
    public Mono<Client> getById(@PathVariable Long id) {
        return Mono.justOrEmpty(service.getById(id));
    }

    @PostMapping
    public Mono<Client> create(@RequestBody Client client) {
        return Mono.fromSupplier(() -> service.save(client));
    }
}