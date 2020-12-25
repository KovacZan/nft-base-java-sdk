package io.kovac.nft.base.client.api.implementations;

import io.kovac.nft.base.client.api.interfaces.IConfigurations;
import org.arkecosystem.client.http.Client;

import java.io.IOException;
import java.util.Map;

public class Configurations implements IConfigurations {

    private final Client client;

    public Configurations(Client client) {
        this.client = client;
    }

    @Override
    public Map<String, Object> all() throws IOException {
        return client.get("configurations");
    }
}
