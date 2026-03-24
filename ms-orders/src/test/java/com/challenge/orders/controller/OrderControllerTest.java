package com.challenge.orders.controller;

import com.challenge.orders.model.Client;
import com.challenge.orders.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Mono;

import static org.mockito.Mockito.when;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class OrderControllerTest {

    @Mock
    private OrderService service;

    @InjectMocks
    private OrderController controller;

    @Test
    void shouldReturnClient() {

        Client client = new Client(
                System.currentTimeMillis(),
                "name-" + System.nanoTime(),
                "mail-" + System.nanoTime()
        );

        when(service.getClient(1L))
                .thenReturn(Mono.just(client));

        Mono<Client> result = controller.getClient(1L);

        Client response = result.block();

        assertThat(response).isNotNull();
        assertThat(response.id()).isEqualTo(client.id());
    }
}