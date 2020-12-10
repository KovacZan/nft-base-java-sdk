package io.kovac.nft.base.crypto.builders;

import io.kovac.nft.base.crypto.transactions.NFTBurn;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

public class NFTBurnBuilder extends AbstractTransactionBuilder<NFTBurnBuilder> {
    @Override
    protected Transaction getTransactionInstance() {
        return new NFTBurn();
    }

    @Override
    protected NFTBurnBuilder instance() {
        return this;
    }
}
