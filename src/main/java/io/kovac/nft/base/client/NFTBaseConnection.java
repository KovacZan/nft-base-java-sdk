package io.kovac.nft.base.client;

import io.kovac.nft.base.client.api.NFTApi;
import org.arkecosystem.client.Connection;

import java.util.Map;

public class NFTBaseConnection extends Connection {

    private final NFTApi nftApi;

    public NFTBaseConnection(Map<String, Object> config) {
        super(config);
        this.nftApi = new NFTApi(this.client());
    }

    public NFTApi nftApi () {
        return this.nftApi;
    }

}
