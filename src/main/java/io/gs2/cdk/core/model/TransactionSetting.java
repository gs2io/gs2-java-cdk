package io.gs2.cdk.core.model;

import java.util.HashMap;
import java.util.Map;

public class TransactionSetting {

    public String distributorNamespaceId;
    public String queueNamespaceId;

    public TransactionSetting(
    ) {
    }

    public Map<String, Object> properties() {
        return new HashMap<>() {
            {
                put("EnableAutoRun", true);
                put("DistributorNamespaceId", distributorNamespaceId);
                put("QueueNamespaceId", queueNamespaceId);
            }
        };
    }
}
