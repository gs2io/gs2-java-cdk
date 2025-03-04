package io.gs2.cdk.core.model;

import io.gs2.cdk.core.model.options.TransactionSettingOptions;

import java.util.HashMap;
import java.util.Map;

public class TransactionSetting {
    private Boolean enableAtomicCommit = false;
    private Boolean transactionUseDistributor = false;
    private Boolean acquireActionUseJobQueue = false;
    private String distributorNamespaceId;
    private String queueNamespaceId;


    public TransactionSetting(
            TransactionSettingOptions options
    ) {
        this.enableAtomicCommit = options.enableAtomicCommit;
        this.transactionUseDistributor = options.transactionUseDistributor;
        this.acquireActionUseJobQueue = options.acquireActionUseJobQueue;
        this.distributorNamespaceId = options.distributorNamespaceId;
        this.queueNamespaceId = options.queueNamespaceId;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();

        if (this.enableAtomicCommit != null) {
            properties.put("EnableAtomicCommit", this.enableAtomicCommit);
        }
        if (this.transactionUseDistributor != null) {
            properties.put("TransactionUseDistributor", this.transactionUseDistributor);
        }
        if (this.acquireActionUseJobQueue != null) {
            properties.put("AcquireActionUseJobQueue", this.acquireActionUseJobQueue);
        }
        if (this.distributorNamespaceId != null) {
            properties.put("DistributorNamespaceId", this.distributorNamespaceId);
        }
        if (this.queueNamespaceId != null) {
            properties.put("QueueNamespaceId", this.queueNamespaceId);
        }

        return properties;
    }
}
