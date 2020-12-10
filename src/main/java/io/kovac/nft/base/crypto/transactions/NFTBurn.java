package io.kovac.nft.base.crypto.transactions;

import io.kovac.nft.base.crypto.enums.NFTTransactionTypes;
import io.kovac.nft.base.crypto.enums.NFTTypeGroup;
import org.arkecosystem.crypto.transactions.types.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

public class NFTBurn extends Transaction {

    @Override
    public int getTransactionType() {
        return NFTTransactionTypes.NFT_BURN.getValue();
    }

    @Override
    public int getTransactionTypeGroup() {
        return NFTTypeGroup.NFT_BASE_TYPE_GROUP.getValue();
    }

    @Override
    public HashMap<String, Object> assetToHashMap() {
        return this.asset.customAsset;
    }

    @Override
    public byte[] serialize() {
        Map <String, String> nftBurn = (Map<String, String>) this.asset.customAsset.get("nftBurn");
        String nftId = nftBurn.get("nftId");
        byte[] nftIdBuffer = nftId.getBytes();

        ByteBuffer buffer = ByteBuffer.allocate(32);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.put(nftIdBuffer);

        return buffer.array();
    }

    @Override
    public void deserialize(ByteBuffer buffer) {
        throw new NotImplementedException();
    }
}
