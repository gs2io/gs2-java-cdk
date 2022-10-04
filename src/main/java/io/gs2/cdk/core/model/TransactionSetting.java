package io.gs2.cdk.core.model;

import java.util.HashMap;
import java.util.Map;

public class TransactionSetting {

    public boolean enableAutoRun;
    public String distributorNamespaceId;
    public String keyId;
    public String queueNamespaceId;

    public TransactionSetting(
            boolean enableAutoRun
    ) {
        this.enableAutoRun = enableAutoRun;
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("EnableAutoRun", enableAutoRun);
                put("DistributorNamespaceId", distributorNamespaceId);
                put("KeyId", keyId);
                put("QueueNamespaceId", queueNamespaceId);
            }
        };
    }
}
