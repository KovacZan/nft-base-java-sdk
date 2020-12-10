package io.kovac.nft.base.examples;

import io.kovac.nft.base.crypto.builders.NFTBurnBuilder;
import org.arkecosystem.client.Connection;
import org.arkecosystem.crypto.configuration.Network;
import org.arkecosystem.crypto.identities.Address;
import org.arkecosystem.crypto.networks.Testnet;
import org.arkecosystem.crypto.transactions.types.Transaction;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NFTBurn {
    public static long getNonce(Connection connection, String senderWallet) throws IOException {
        return Long.valueOf (((Map<String, Object>) connection.api().wallets.show(senderWallet).get("data")).get("nonce").toString());
    }
    public static void main(String[] args) throws IOException {
        Network.set(new Testnet());

        Map<String, Object> map = new HashMap<>();
        map.put("host", "http://localhost:4003/api/");
        map.put("content-type","application/json");

        Connection connection = new Connection(map);

        long nonce = getNonce(connection, Address.fromPassphrase("clay harbor enemy utility margin pretty hub comic piece aerobic umbrella acquire")) + 1;

        List payload = new ArrayList<>();

        Transaction transaction = new NFTBurnBuilder()
                .nonce(nonce)
                .NFTBurnAsset("NFT_ID")
                .sign("clay harbor enemy utility margin pretty hub comic piece aerobic umbrella acquire")
                .transaction;

        payload.add(transaction.toHashMap());
        Map<String, Object> postResponse = connection.api().transactions.create(payload);
        System.out.println(postResponse);
    }
}
