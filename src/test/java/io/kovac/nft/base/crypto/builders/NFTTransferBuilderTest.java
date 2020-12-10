package io.kovac.nft.base.crypto.builders;

import org.arkecosystem.crypto.identities.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NFTTransferBuilderTest {
    private NFTTransferBuilder nftTransferBuilder;

    @BeforeEach
    void initEach () {
        this.nftTransferBuilder = new NFTTransferBuilder();
    }

    @Test
    void getTransactionInstance() {
        assertDoesNotThrow(this.nftTransferBuilder::getTransactionInstance);
    }

    @Test
    void instance() {
        assertDoesNotThrow(this.nftTransferBuilder::instance);
    }

    @Test
    void NFTTransferAsset() {
        assertDoesNotThrow(() -> this.nftTransferBuilder
                .NFTTransferAsset(
                        Arrays.asList("468d16162e074fcad2b62ba1ec09a87a21eee5aff6a551c8fc690b425c14d5ce"),
                        Address.fromPassphrase("passphrase")
                )
        );
    }
}