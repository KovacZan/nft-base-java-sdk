package io.kovac.nft.base.client.api.interfaces;

import java.io.IOException;
import java.util.Map;

public interface ICollections {

    Map<String, Object> all() throws IOException;

    Map<String, Object> show(String id) throws IOException;

    Map<String, Object> showSchema(String id) throws IOException;

    Map<String, Object> showWallet(String id) throws IOException;

    Map<String, Object> search(Map<String, Object> parameters) throws IOException;

    Map<String, Object> showAssets(String id) throws IOException;

}
