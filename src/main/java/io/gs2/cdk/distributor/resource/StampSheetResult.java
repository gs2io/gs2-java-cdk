/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

package io.gs2.cdk.distributor.resource;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.core.model.Stack;
import io.gs2.cdk.distributor.ref.*;
import io.gs2.cdk.distributor.model.*;

import java.util.*;
import java.util.stream.*;

public class StampSheetResult {
	public String userId;
	public String transactionId;
	public List<ConsumeAction> taskRequests;
	public AcquireAction sheetRequest;
	public List<String> taskResults;
	public String sheetResult;
	public String nextTransactionId;
	public Long createdAt;
	public Long ttlAt;

    public StampSheetResult(
            String userId,
            String transactionId,
            AcquireAction sheetRequest,
            Long createdAt,
            Long ttlAt
    ) {
        this.userId = userId;
        this.transactionId = transactionId;
        this.sheetRequest = sheetRequest;
        this.createdAt = createdAt;
        this.ttlAt = ttlAt;
  }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.userId != null) {
            properties.put("UserId", this.userId);
        }
        if (this.transactionId != null) {
            properties.put("TransactionId", this.transactionId);
        }
        if (this.taskRequests != null) {
            properties.put("TaskRequests", this.taskRequests.stream().map(ConsumeAction::properties).collect(Collectors.toList()));
        }
        if (this.sheetRequest != null) {
            properties.put("SheetRequest", this.sheetRequest.properties());
        }
        if (this.taskResults != null) {
            properties.put("TaskResults", this.taskResults);
        }
        if (this.sheetResult != null) {
            properties.put("SheetResult", this.sheetResult);
        }
        if (this.nextTransactionId != null) {
            properties.put("NextTransactionId", this.nextTransactionId);
        }
        if (this.createdAt != null) {
            properties.put("CreatedAt", this.createdAt);
        }
        if (this.ttlAt != null) {
            properties.put("TtlAt", this.ttlAt);
        }
        return properties;
    }
}
