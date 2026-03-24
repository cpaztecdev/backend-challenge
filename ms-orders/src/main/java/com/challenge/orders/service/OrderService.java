package com.challenge.orders.service;

import com.challenge.orders.model.Client;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final WebClient webClient;

    public Mono<Client> getClient(Long id) {
        return webClient.get()
                .uri("/clients/{id}", id)
                .retrieve()
                .bodyToMono(Client.class)
                .onErrorResume(e -> Mono.error(new RuntimeException("Error calling client MS")));
    }
}
