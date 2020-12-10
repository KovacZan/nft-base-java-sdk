package io.kovac.nft.base.crypto.enums;

public enum NFTTransactionTypes {
    NFT_REGISTER_COLLECTION(0),
    NFT_CREATE(1),
    NFT_TRANSFER(2),
    NFT_BURN(3);

    private final int value;

    NFTTransactionTypes(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
