package io.kovac.nft.base.client.api.implementations;

import io.kovac.nft.base.client.api.interfaces.ITransfers;
import org.arkecosystem.client.http.Client;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.Map;

public class Transfers implements ITransfers {

    private final Client client;

    public Transfers(Client client) {
        this.client = client;
    }

    @Override
    public Map<String, Object> all() throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> show(String id) throws IOException {
        throw new NotImplementedException();
    }
}
