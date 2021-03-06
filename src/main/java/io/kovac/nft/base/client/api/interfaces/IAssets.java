package io.kovac.nft.base.client.api.interfaces;

import java.io.IOException;
import java.util.Map;

public interface IAssets {

    Map<String, Object> all() throws IOException;

    Map<String, Object> show(String id) throws IOException;

    Map<String, Object> showWallet(String id) throws IOException;

    Map<String, Object> search(Map<String, Object> parameters) throws IOException;

}
