package com.challenge.clients.util;

import com.challenge.clients.model.Client;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class ClientTestData {

    public static Client random() {
        Long id = ThreadLocalRandom.current().nextLong(1, 10000);
        String name = "name-" + UUID.randomUUID();
        String email = "mail-" + UUID.randomUUID() + "@test.com";

        return new Client(id, name, email);
    }
}
