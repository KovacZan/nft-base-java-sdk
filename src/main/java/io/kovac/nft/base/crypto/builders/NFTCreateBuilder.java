package io.kovac.nft.base.crypto.builders;

import io.kovac.nft.base.crypto.transactions.NFTCreate;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

public class NFTCreateBuilder extends AbstractTransactionBuilder<NFTCreateBuilder> {
    @Override
    protected Transaction getTransactionInstance() {
        return new NFTCreate();
    }

    @Override
    protected NFTCreateBuilder instance() {
        return this;
    }
}
