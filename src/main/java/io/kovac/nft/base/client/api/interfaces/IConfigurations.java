package io.kovac.nft.base.client.api.interfaces;

import java.io.IOException;
import java.util.Map;

public interface IConfigurations {

    Map<String, Object> all() throws IOException;

}
