package io.kovac.nft.base.examples;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;
import io.kovac.nft.base.crypto.builders.NFTCreateBuilder;
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

public class NFTCreateToken {

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

        Transaction transaction = new NFTCreateBuilder()
                .nonce(nonce)
                .NFTCreateToken("fd23ed90d7cd6b5978ad55239256c4fc5ec6767ccde1a006c380645ba155f194", "{\"name\":\"card name\",\"damage\":3,\"health\":2,\"mana\":2}")
                .sign("clay harbor enemy utility margin pretty hub comic piece aerobic umbrella acquire")
                .transaction;

        Gson GSON = new GsonBuilder().setPrettyPrinting().create();
        System.out.println("Formatted Json");
        System.out.println(GSON.toJson(JsonParser.parseString(transaction.toJson())));

        payload.add(transaction.toHashMap());

        System.out.println("Payload response");
        Map<String, Object> postResponse = connection.api().transactions.create(payload);
        System.out.println(postResponse);
    }
}
