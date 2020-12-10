package io.kovac.nft.base.client.api.implementations;

import io.kovac.nft.base.client.api.interfaces.IAssets;
import org.arkecosystem.client.http.Client;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.io.IOException;
import java.util.Map;

public class Assets implements IAssets {

    private final Client client;

    public Assets(Client client) {
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
    public Map<String, Object> showWallet(String id) throws IOException {
        throw new NotImplementedException();
    }

    @Override
    public Map<String, Object> search(Map<String, Object> parameters) throws IOException {
        throw new NotImplementedException();
    }
}
