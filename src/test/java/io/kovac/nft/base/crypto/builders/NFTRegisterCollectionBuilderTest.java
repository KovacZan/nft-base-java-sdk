package io.kovac.nft.base.crypto.builders;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class NFTRegisterCollectionBuilderTest {

    private NFTRegisterCollectionBuilder nftRegisterCollectionBuilder;

    @BeforeEach
    void initEach () {
        this.nftRegisterCollectionBuilder = new NFTRegisterCollectionBuilder();
    }

    @Test
    void getTransactionInstance() {
        assertDoesNotThrow(this.nftRegisterCollectionBuilder::getTransactionInstance);

    }

    @Test
    void instance() {
        assertDoesNotThrow(this.nftRegisterCollectionBuilder::instance);
    }

    @Test
    void NFTRegisterCollectionAssetAllowedIssuers() {
        assertDoesNotThrow(() -> this.nftRegisterCollectionBuilder
                .NFTRegisterCollectionAsset(
                        "Test1",
                        "Test java",
                        10,
                        "{\"properties\":{\"number\":{\"type\":\"number\"},\"string\":{\"type\":\"string\"}}}",
                        Arrays.asList(
                                "03287bfebba4c7881a0509717e71b34b63f31e40021c321f89ae04f84be6d6ac37",
                                "030c8ee7a2026ac23dbcb650e08cda9fc6386805fa2d788e6a72ba01d72fdcc75e"
                        )
                )
        );

    }

    @Test
    void NFTRegisterCollectionAsset() {
        assertDoesNotThrow(() -> this.nftRegisterCollectionBuilder
                .NFTRegisterCollectionAsset(
                        "Test1",
                        "Test java",
                        10,
                        "{\"properties\":{\"number\":{\"type\":\"number\"},\"string\":{\"type\":\"string\"}}}")
        );
    }
}