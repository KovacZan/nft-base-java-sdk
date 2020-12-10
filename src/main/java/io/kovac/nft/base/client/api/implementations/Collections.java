package io.kovac.nft.base.client.api.implementations;

import io.kovac.nft.base.client.api.interfaces.ICollections;
import org.arkecosystem.client.http.Client;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.Map;

public class Collections implements ICollections {

    private final Client client;

    public Collections(Client client) {
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

    @Override
    public Map<String, Object> showSchema(String id) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> showWallet(String id) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> search(Map<String, Object> parameters) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> showAssets(String id) throws IOException {
        throw new NotImplementedException();
    }
}
