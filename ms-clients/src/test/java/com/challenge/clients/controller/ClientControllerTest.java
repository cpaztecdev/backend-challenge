package com.challenge.clients.controller;

import com.challenge.clients.model.Client;
import com.challenge.clients.service.ClientService;
import com.challenge.clients.util.ClientTestData;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.core.publisher.Flux;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientControllerTest {

    @Mock
    private ClientService service;

    @InjectMocks
    private ClientController controller;

    @Test
    void shouldReturnClients() {

        Client client = ClientTestData.random();

        when(service.getAll())
                .thenReturn(List.of(client));

        Flux<Client> result = controller.getAll();

        List<Client> response = result.collectList().block();

        assertThat(response)
                .isNotNull()
                .hasSize(1);

        assertThat(response.get(0).id())
                .isEqualTo(client.id());
    }
}