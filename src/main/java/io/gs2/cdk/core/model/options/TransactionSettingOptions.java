/*
 * Copyright 2016- Game Server Services, Inc. or its affiliates. All Rights
 * Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */
package io.gs2.cdk.core.model.options;

public class TransactionSettingOptions {
    public Boolean enableAtomicCommit;
    public Boolean transactionUseDistributor;
    public Boolean acquireActionUseJobQueue;
    public String distributorNamespaceId;
    public String queueNamespaceId;

    public TransactionSettingOptions withEnableAtomicCommit(
            Boolean enableAtomicCommit
    ) {
        this.enableAtomicCommit = enableAtomicCommit;
        return this;
    }

    public TransactionSettingOptions withTransactionUseDistributor(
            Boolean transactionUseDistributor
    ) {
        this.transactionUseDistributor = transactionUseDistributor;
        return this;
    }
    
    public TransactionSettingOptions withAcquireActionUseJobQueue(
            Boolean acquireActionUseJobQueue
    ) {
        this.acquireActionUseJobQueue = acquireActionUseJobQueue;
        return this;
    }

    public TransactionSettingOptions withDistributorNamespaceId(
            String distributorNamespaceId
    ) {
        this.distributorNamespaceId = distributorNamespaceId;
        return this;
    }

    public TransactionSettingOptions withQueueNamespaceId(
            String queueNamespaceId
    ) {
        this.queueNamespaceId = queueNamespaceId;
        return this;
    }
}
