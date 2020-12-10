package io.kovac.nft.base.crypto.enums;

public enum NFTBaseFees {
    NFT_REGISTER_COLLECTION(500_000_000L),
    NFT_CREATE(500_000_000L),
    NFT_TRANSFER(500_000_000L),
    NFT_BURN(500_000_000L);

    private final Long value;

    NFTBaseFees(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }
}
