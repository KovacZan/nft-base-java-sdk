package io.kovac.nft.base.client.api;

import io.kovac.nft.base.client.api.implementations.*;
import io.kovac.nft.base.client.api.interfaces.*;
import org.arkecosystem.client.http.Client;

public class NFTApi {

    public final IAssets assets;
    public final IBurns burns;
    public final ICollections collections;
    public final IConfigurations configurations;
    public final ITransfers transfers;

    public NFTApi(Client client) {
        this.assets = new Assets(client);
        this.burns = new Burns(client);
        this.collections = new Collections(client);
        this.configurations = new Configurations(client);
        this.transfers = new Transfers(client);
    }

}
