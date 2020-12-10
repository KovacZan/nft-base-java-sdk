package io.kovac.nft.base.client.api.interfaces;

import java.io.IOException;
import java.util.Map;

public interface ITransfers {

    Map<String, Object> all() throws IOException;

    Map<String, Object> show(String id) throws IOException;

}
