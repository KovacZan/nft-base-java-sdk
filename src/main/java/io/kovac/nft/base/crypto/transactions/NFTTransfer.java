package io.kovac.nft.base.crypto.transactions;

import io.kovac.nft.base.crypto.enums.NFTTransactionTypes;
import io.kovac.nft.base.crypto.enums.NFTTypeGroup;
import org.arkecosystem.crypto.encoding.Base58;
import org.arkecosystem.crypto.encoding.Hex;
import org.arkecosystem.crypto.transactions.types.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NFTTransfer extends Transaction {
    @Override
    public int getTransactionType() {
        return NFTTransactionTypes.NFT_TRANSFER.getValue();
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
        Map<String, ?> nftTransfer = (Map<String, ?>) this.asset.customAsset.get("nftTransfer");

        List<String> nftIds = (List<String>) nftTransfer.get("nftIds");

        String recipientId = (String) nftTransfer.get("recipientId");

        ByteBuffer buffer = ByteBuffer.allocate(1 + nftIds.size() * 32 + 21);

        buffer.put((byte) nftIds.size());
        for (String nft : nftIds) {
            buffer.put(Hex.decode(nft));
        }

        buffer.put(Base58.decodeChecked(recipientId));

        return buffer.array();
    }

    @Override
    public void deserialize(ByteBuffer buffer) {
        throw new NotImplementedException();
    }
}
