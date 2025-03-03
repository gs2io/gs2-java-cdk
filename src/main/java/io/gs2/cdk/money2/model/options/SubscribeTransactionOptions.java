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
package io.gs2.cdk.money2.model.options;
import io.gs2.cdk.money2.model.enums.SubscribeTransactionStore;
import io.gs2.cdk.money2.model.enums.SubscribeTransactionStatusDetail;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class SubscribeTransactionOptions {
    public String userId;
    public Long lastAllocatedAt;
    public Long lastTakeOverAt;
    public Long revision;
    
    public SubscribeTransactionOptions withUserId(
        String userId
    ) {
        this.userId = userId;
        return this;
    }
    
    public SubscribeTransactionOptions withLastAllocatedAt(
        Long lastAllocatedAt
    ) {
        this.lastAllocatedAt = lastAllocatedAt;
        return this;
    }
    
    public SubscribeTransactionOptions withLastTakeOverAt(
        Long lastTakeOverAt
    ) {
        this.lastTakeOverAt = lastTakeOverAt;
        return this;
    }
    
    public SubscribeTransactionOptions withRevision(
        Long revision
    ) {
        this.revision = revision;
        return this;
    }
}

