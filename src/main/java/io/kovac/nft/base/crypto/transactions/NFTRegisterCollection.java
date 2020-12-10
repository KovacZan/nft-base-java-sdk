package io.kovac.nft.base.crypto.transactions;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import io.kovac.nft.base.crypto.enums.NFTTransactionTypes;
import io.kovac.nft.base.crypto.enums.NFTTypeGroup;
import io.kovac.nft.base.utls.Cloning;
import org.arkecosystem.crypto.transactions.types.Transaction;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        HashMap <String, Object> map = (HashMap<String, Object>) Cloning.deepCopy(this.asset.customAsset);

        String schema = (String) ((Map<String,Object>)map.get("nftCollection")).get("jsonSchema");

        JsonParser parser = new JsonParser();
        JsonObject o = parser.parse(schema).getAsJsonObject();

        HashMap<String, Object> schemaMap = new Gson().fromJson(o, HashMap.class);
        ((Map<String,Object>)map.get("nftCollection")).put("jsonSchema", schemaMap);

        return map;
    }

    @Override
    public byte[] serialize() {
        Map<String, ?> nftCollection = (Map<String, ?>) this.asset.customAsset.get("nftCollection");

        String name = (String) nftCollection.get("name");
        byte[] nameBuffer = name.getBytes();

        String description = (String) nftCollection.get("description");
        byte[] descriptionBuffer = description.getBytes();

        int maximumSupply = (Integer) nftCollection.get("maximumSupply");

        String jsonSchema = (String) nftCollection.get("jsonSchema");
        byte[] jsonSchemaBuffer = jsonSchema.getBytes();

        boolean hasIssuers = nftCollection.containsKey("allowedIssuers");
        List<String> allowedIssuers = null;
        if (hasIssuers) {
            allowedIssuers = (List<String>) nftCollection.get("allowedIssuers");
        }

        int bufferLength = nameBuffer.length + 1 + descriptionBuffer.length + 1 + 4 + jsonSchemaBuffer.length + 4;
        if(hasIssuers) {
            bufferLength += (66 * allowedIssuers.size());
        } else {
            bufferLength += 1;
        }

        ByteBuffer buffer = ByteBuffer.allocate(bufferLength);
        buffer.order(ByteOrder.LITTLE_ENDIAN);

        buffer.put((byte) nameBuffer.length);
        buffer.put(nameBuffer);

        buffer.put((byte) descriptionBuffer.length);
        buffer.put(descriptionBuffer);

        buffer.putInt(maximumSupply);

        buffer.putInt(jsonSchemaBuffer.length);
        buffer.put(jsonSchemaBuffer);

        if (hasIssuers){
            buffer.put((byte) allowedIssuers.size());
            for (String issuer : allowedIssuers) {
                buffer.put(issuer.getBytes());
            }
        } else {
            buffer.put((byte) 0);
        }

        return buffer.array();
    }

    @Override
    public void deserialize(ByteBuffer buffer) {
        throw new NotImplementedException();
    }
}
