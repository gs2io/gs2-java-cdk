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
package io.gs2.cdk.money2.model;
import io.gs2.cdk.money2.model.options.SubscribeTransactionOptions;
import io.gs2.cdk.money2.model.enums.SubscribeTransactionStore;
import io.gs2.cdk.money2.model.enums.SubscribeTransactionStatusDetail;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class SubscribeTransaction {
    private String contentName;
    private String transactionId;
    private SubscribeTransactionStore store;
    private SubscribeTransactionStatusDetail statusDetail;
    private Long expiresAt;
    private String userId = null;
    private Long lastAllocatedAt = null;
    private Long lastTakeOverAt = null;
    private Long revision = null;

    public SubscribeTransaction(
        String contentName,
        String transactionId,
        SubscribeTransactionStore store,
        SubscribeTransactionStatusDetail statusDetail,
        Long expiresAt,
        SubscribeTransactionOptions options
    ) {
        this.contentName = contentName;
        this.transactionId = transactionId;
        this.store = store;
        this.statusDetail = statusDetail;
        this.expiresAt = expiresAt;
        this.userId = options.userId;
        this.lastAllocatedAt = options.lastAllocatedAt;
        this.lastTakeOverAt = options.lastTakeOverAt;
        this.revision = options.revision;
    }
    public SubscribeTransaction(
        String contentName,
        String transactionId,
        SubscribeTransactionStore store,
        SubscribeTransactionStatusDetail statusDetail,
        Long expiresAt
    ) {
        this.contentName = contentName;
        this.transactionId = transactionId;
        this.store = store;
        this.statusDetail = statusDetail;
        this.expiresAt = expiresAt;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.contentName != null) {
            properties.put("contentName", this.contentName);
        }
        if (this.transactionId != null) {
            properties.put("transactionId", this.transactionId);
        }
        if (this.store != null) {
            properties.put("store", this.store.toString(
            ));
        }
        if (this.userId != null) {
            properties.put("userId", this.userId);
        }
        if (this.statusDetail != null) {
            properties.put("statusDetail", this.statusDetail.toString(
            ));
        }
        if (this.expiresAt != null) {
            properties.put("expiresAt", this.expiresAt);
        }
        if (this.lastAllocatedAt != null) {
            properties.put("lastAllocatedAt", this.lastAllocatedAt);
        }
        if (this.lastTakeOverAt != null) {
            properties.put("lastTakeOverAt", this.lastTakeOverAt);
        }

        return properties;
    }
}
