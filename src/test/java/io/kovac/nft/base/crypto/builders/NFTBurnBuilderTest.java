package io.kovac.nft.base.crypto.builders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NFTBurnBuilderTest {
    private NFTBurnBuilder nftBurnBuilder;

    @BeforeEach
    void initEach () {
        this.nftBurnBuilder = new NFTBurnBuilder();
    }

    @Test
    void getTransactionInstance() {
        assertDoesNotThrow(this.nftBurnBuilder::getTransactionInstance);
    }

    @Test
    void instance() {
        assertDoesNotThrow(this.nftBurnBuilder::instance);
    }

    @Test
    void NFTBurnAsset() {
        assertDoesNotThrow(() -> this.nftBurnBuilder.NFTBurnAsset("468d16162e074fcad2b62ba1ec09a87a21eee5aff6a551c8fc690b425c14d5ce"));
    }
}