package io.kovac.nft.base.crypto.builders;

import io.kovac.nft.base.crypto.enums.NFTBaseFees;
import io.kovac.nft.base.crypto.transactions.NFTCreate;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.util.HashMap;

public class NFTCreateBuilder extends AbstractTransactionBuilder<NFTCreateBuilder> {

    public NFTCreateBuilder() {
        super();
        this.transaction.fee = NFTBaseFees.NFT_CREATE.getValue();
    }

    public NFTCreateBuilder NFTCreateToken(String collectionId, String attributes) {
        HashMap<String, Object> nftToken = new HashMap<>();
        nftToken.put("collectionId", collectionId);
        nftToken.put("attributes", attributes);

        HashMap<String, Object> nftTokenMap = new HashMap<>();
        nftTokenMap.put("nftToken", nftToken);

        this.transaction.asset.customAsset = nftTokenMap;

        return this;
    }

    @Override
    protected Transaction getTransactionInstance() {
        return new NFTCreate();
    }

    @Override
    protected NFTCreateBuilder instance() {
        return this;
    }
}
