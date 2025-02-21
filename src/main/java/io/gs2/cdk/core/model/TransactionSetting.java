package io.gs2.cdk.core.model;

import io.gs2.cdk.core.model.options.TransactionSettingOptions;

import java.util.HashMap;
import java.util.Map;

public class TransactionSetting {

    private String distributorNamespaceId;
    private String queueNamespaceId;

    public TransactionSetting(
            TransactionSettingOptions options
    ) {
        this.distributorNamespaceId = options.distributorNamespaceId;
        this.queueNamespaceId = options.queueNamespaceId;
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
