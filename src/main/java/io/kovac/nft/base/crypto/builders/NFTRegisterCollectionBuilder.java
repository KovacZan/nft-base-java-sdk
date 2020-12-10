package io.kovac.nft.base.crypto.builders;

import io.kovac.nft.base.crypto.enums.NFTBaseFees;
import io.kovac.nft.base.crypto.transactions.NFTRegisterCollection;
import org.arkecosystem.crypto.transactions.builder.AbstractTransactionBuilder;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.util.HashMap;
import java.util.List;

public class NFTRegisterCollectionBuilder extends AbstractTransactionBuilder<NFTRegisterCollectionBuilder> {

    public NFTRegisterCollectionBuilder() {
        super();
        this.transaction.fee = NFTBaseFees.NFT_REGISTER_COLLECTION.getValue();
    }

    public NFTRegisterCollectionBuilder NFTRegisterCollectionAsset(String name,
                                                                   String description,
                                                                   int maximumSupply,
                                                                   String jsonSchema,
                                                                   List<String> allowedIssuers) {

        HashMap<String, Object> nftCollection = new HashMap<>();
        nftCollection.put("name", name);
        nftCollection.put("description", description);
        nftCollection.put("maximumSupply", maximumSupply);
        nftCollection.put("jsonSchema", jsonSchema);
        nftCollection.put("allowedIssuers", allowedIssuers);

        HashMap<String, Object> nftCollectionMap = new HashMap<>();
        nftCollectionMap.put("nftCollection", nftCollection);

        this.transaction.asset.customAsset = nftCollectionMap;

        return this;
    }

    public NFTRegisterCollectionBuilder NFTRegisterCollectionAsset(String name,
                                                                   String description,
                                                                   int maximumSupply,
                                                                   String jsonSchema) {

        HashMap<String, Object> nftCollection = new HashMap<>();

        nftCollection.put("name", name);
        nftCollection.put("description", description);
        nftCollection.put("maximumSupply", maximumSupply);
        nftCollection.put("jsonSchema", jsonSchema);

        HashMap<String, Object> nftCollectionMap = new HashMap<>();
        nftCollectionMap.put("nftCollection", nftCollection);

        this.transaction.asset.customAsset = nftCollectionMap;

        return this;
    }

    @Override
    protected Transaction getTransactionInstance() {
        return new NFTRegisterCollection();
    }

    @Override
    protected NFTRegisterCollectionBuilder instance() {
        return this;
    }
}
