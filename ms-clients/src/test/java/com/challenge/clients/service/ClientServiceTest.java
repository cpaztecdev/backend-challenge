package com.challenge.clients.service;

import com.challenge.clients.model.Client;
import com.challenge.clients.repository.ClientRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ClientServiceTest {

    private ClientService service;

    @BeforeEach
    void setup() {
        service = new ClientService(new ClientRepository());
    }

    @Test
    void shouldSaveClient() {
        service.save(new Client(1L, "Carlos", "test@mail.com"));

        Client result = service.getById(1L);

        assertThat(result).isNotNull();
        assertThat(result.name()).isEqualTo("Carlos");
    }
}