package io.gs2.cdk.core.model;

import java.util.HashMap;
import java.util.Map;

public class Config {

    String key;
    String value;

    public Config(
            String key,
            String value
    ) {
        this.key = key;
        this.value = value;
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("Key", key);
                put("Value", value);
            }
        };
    }
}
