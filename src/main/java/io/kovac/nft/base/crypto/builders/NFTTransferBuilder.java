package io.kovac.nft.base.crypto.builders;

import io.kovac.nft.base.crypto.transactions.NFTTransfer;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

public class NFTTransferBuilder extends AbstractTransactionBuilder<NFTTransferBuilder> {
    @Override
    protected Transaction getTransactionInstance() {
        return new NFTTransfer();
    }

    @Override
    protected NFTTransferBuilder instance() {
        return this;
    }
}
