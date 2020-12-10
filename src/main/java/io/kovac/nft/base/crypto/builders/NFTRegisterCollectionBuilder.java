package io.kovac.nft.base.crypto.builders;

import io.kovac.nft.base.crypto.transactions.NFTRegisterCollection;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

public class NFTRegisterCollectionBuilder extends AbstractTransactionBuilder<NFTRegisterCollectionBuilder> {
    @Override
    protected Transaction getTransactionInstance() {
        return new NFTRegisterCollection();
    }

    @Override
    protected NFTRegisterCollectionBuilder instance() {
        return this;
    }
}
