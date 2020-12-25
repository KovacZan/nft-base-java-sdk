package io.kovac.nft.base.client;

import io.kovac.nft.base.client.api.NFTBaseApi;
import org.arkecosystem.client.Connection;

import java.util.Map;

public class NFTBaseConnection extends Connection {

    private final NFTBaseApi nftBaseApi;

    public NFTBaseConnection(Map<String, Object> config) {
        super(config);
        this.nftBaseApi = new NFTBaseApi(this.client());
    }

    public NFTBaseApi nftBaseApi () {
        return this.nftBaseApi;
    }

}
