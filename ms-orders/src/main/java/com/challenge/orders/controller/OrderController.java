package com.challenge.orders.controller;

import com.challenge.orders.model.Client;
import com.challenge.orders.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService service;

    @GetMapping("/client/{id}")
    public Mono<Client> getClient(Long id) {
        return service.getClient(id);
    }
}
