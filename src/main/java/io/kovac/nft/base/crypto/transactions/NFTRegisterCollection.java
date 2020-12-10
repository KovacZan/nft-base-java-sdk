package io.kovac.nft.base.crypto.transactions;

import io.kovac.nft.base.crypto.enums.NFTTransactionTypes;
import io.kovac.nft.base.crypto.enums.NFTTypeGroup;
import org.arkecosystem.crypto.transactions.types.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.ByteBuffer;
import java.util.HashMap;

public class NFTRegisterCollection extends Transaction {
    @Override
    public int getTransactionType() {
        return NFTTransactionTypes.NFT_REGISTER_COLLECTION.getValue();
    }

    @Override
    public int getTransactionTypeGroup() {
        return NFTTypeGroup.NFT_BASE_TYPE_GROUP.getValue();
    }

    @Override
    public HashMap<String, Object> assetToHashMap() {
        throw new NotImplementedException();
    }

    @Override
    public byte[] serialize() {
        throw new NotImplementedException();
    }

    @Override
    public void deserialize(ByteBuffer buffer) {
        throw new NotImplementedException();
    }
}
