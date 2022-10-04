package io.gs2.cdk.core.model;

import java.util.HashMap;
import java.util.Map;

public class LogSetting {

    String loggingNamespaceId;

    public LogSetting(
            String loggingNamespaceId
    ) {
        this.loggingNamespaceId = loggingNamespaceId;
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("LoggingNamespaceId", loggingNamespaceId);
            }
        };
    }
}
