package io.kovac.nft.base.crypto.builders;

import io.kovac.nft.base.crypto.enums.NFTBaseFees;
import io.kovac.nft.base.crypto.transactions.NFTBurn;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.util.HashMap;
import java.util.Map;

public class NFTBurnBuilder extends AbstractTransactionBuilder<NFTBurnBuilder> {

    public NFTBurnBuilder() {
        super();
        this.transaction.fee = NFTBaseFees.NFT_BURN.getValue();
    }

    public NFTBurnBuilder NFTBurnAsset(String nftId) {
        HashMap<String, Object> nftBurn = new HashMap<>();
        Map<String, String> nftIdMap = new HashMap<>();

        nftIdMap.put("nftId", nftId);

        nftBurn.put("nftBurn", nftIdMap);

        this.transaction.asset.customAsset = nftBurn;

        return this;
    }

    @Override
    protected Transaction getTransactionInstance() {
        return new NFTBurn();
    }

    @Override
    protected NFTBurnBuilder instance() {
        return this;
    }
}
