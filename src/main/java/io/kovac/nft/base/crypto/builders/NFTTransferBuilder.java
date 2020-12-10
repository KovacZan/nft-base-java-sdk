package io.kovac.nft.base.crypto.builders;

import io.kovac.nft.base.crypto.enums.NFTBaseFees;
import io.kovac.nft.base.crypto.transactions.NFTTransfer;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.util.HashMap;
import java.util.List;

public class NFTTransferBuilder extends AbstractTransactionBuilder<NFTTransferBuilder> {

    public NFTTransferBuilder() {
        super();
        this.transaction.fee = NFTBaseFees.NFT_TRANSFER.getValue();
    }

    public NFTTransferBuilder NFTTransferAsset (List<String> nftIds, String recipientId) {
        HashMap<String, Object> nftTransfer = new HashMap<>();
        nftTransfer.put("nftIds", nftIds);
        nftTransfer.put("recipientId", recipientId);

        HashMap<String, Object> nftTransferMap = new HashMap<>();
        nftTransferMap.put("nftTransfer", nftTransfer);

        this.transaction.asset.customAsset = nftTransferMap;

        return this;
    }
    @Override
    protected Transaction getTransactionInstance() {
        return new NFTTransfer();
    }

    @Override
    protected NFTTransferBuilder instance() {
        return this;
    }
}
