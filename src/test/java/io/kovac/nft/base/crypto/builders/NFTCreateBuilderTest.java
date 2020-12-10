package io.kovac.nft.base.crypto.builders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NFTCreateBuilderTest {

    private NFTCreateBuilder nftCreateBuilder;

    @BeforeEach
    void initEach () {
        this.nftCreateBuilder = new NFTCreateBuilder();
    }

    @Test
    void getTransactionInstance() {
        assertDoesNotThrow(this.nftCreateBuilder::getTransactionInstance);

    }

    @Test
    void instance() {
        assertDoesNotThrow(this.nftCreateBuilder::instance);
    }

    @Test
    void NFTCreateToken() {
        assertDoesNotThrow(() -> this.nftCreateBuilder
                .NFTCreateToken(
                        "468d16162e074fcad2b62ba1ec09a87a21eee5aff6a551c8fc690b425c14d5ce",
                        "{\"number\":5,\"string\":\"something\"}"
                )
        );
    }
}