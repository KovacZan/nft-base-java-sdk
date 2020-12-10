package io.kovac.nft.base.crypto.enums;

public enum NFTTypeGroup {
    NFT_BASE_TYPE_GROUP(9000);

    private final int value;

    NFTTypeGroup(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
