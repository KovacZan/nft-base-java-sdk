package io.kovac.nft.base.crypto.transactions;

import com.google.gson.Gson;
import io.kovac.nft.base.crypto.enums.NFTTransactionTypes;
import io.kovac.nft.base.crypto.enums.NFTTypeGroup;
import io.kovac.nft.base.utls.Cloning;
import org.arkecosystem.crypto.transactions.types.Transaction;
import org.bouncycastle.util.encoders.Hex;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class NFTCreate extends Transaction {
    @Override
    public int getTransactionType() {
        return NFTTransactionTypes.NFT_CREATE.getValue();
    }

    @Override
    public int getTransactionTypeGroup() {
        return NFTTypeGroup.NFT_BASE_TYPE_GROUP.getValue();
    }

    @Override
    public HashMap<String, Object> assetToHashMap() {
        HashMap <String, Object> map = (HashMap<String, Object>) Cloning.deepCopy(this.asset.customAsset);

        String schema = (String) ((Map<String,Object>)map.get("nftToken")).get("attributes");

        LinkedHashMap<String, Object> schemaMap = new Gson().fromJson(schema, LinkedHashMap.class);
        ((Map<String,Object>)map.get("nftToken")).put("attributes", schemaMap);

        return map;
    }

    @Override
    public byte[] serialize() {
        Map<String, ?> nftToken = (Map<String, ?>) this.asset.customAsset.get("nftToken");

        String collectionId = (String) nftToken.get("collectionId");
        byte[] collectionIdBuffer = collectionId.getBytes();

        String attributes = (String) nftToken.get("attributes");
        byte [] attributesBuffer = attributes.getBytes();

        ByteBuffer buffer = ByteBuffer.allocate(32 + attributesBuffer.length + 4);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.put(Hex.decode(collectionIdBuffer));

        buffer.putInt(attributesBuffer.length);
        buffer.put(attributesBuffer);

        return buffer.array();
    }

    @Override
    public void deserialize(ByteBuffer buffer) {
        throw new NotImplementedException();
    }
}
