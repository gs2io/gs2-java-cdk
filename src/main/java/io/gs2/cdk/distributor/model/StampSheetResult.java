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
package io.gs2.cdk.distributor.model;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.distributor.model.options.StampSheetResultOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class StampSheetResult {
    private String userId;
    private String transactionId;
    private AcquireAction sheetRequest;
    private Long createdAt;
    private Long ttlAt;
    private List<ConsumeAction> taskRequests = null;
    private List<String> taskResults = null;
    private String sheetResult = null;
    private String nextTransactionId = null;

    public StampSheetResult(
        String userId,
        String transactionId,
        AcquireAction sheetRequest,
        Long createdAt,
        Long ttlAt,
        StampSheetResultOptions options
    ) {
        this.userId = userId;
        this.transactionId = transactionId;
        this.sheetRequest = sheetRequest;
        this.createdAt = createdAt;
        this.ttlAt = ttlAt;
        this.taskRequests = options.taskRequests;
        this.taskResults = options.taskResults;
        this.sheetResult = options.sheetResult;
        this.nextTransactionId = options.nextTransactionId;
    }
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

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.userId != null) {
            properties.put("userId", this.userId);
        }
        if (this.transactionId != null) {
            properties.put("transactionId", this.transactionId);
        }
        if (this.taskRequests != null) {
            properties.put("taskRequests", this.taskRequests.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.sheetRequest != null) {
            properties.put("sheetRequest", this.sheetRequest.properties(
            ));
        }
        if (this.taskResults != null) {
            properties.put("taskResults", this.taskResults);
        }
        if (this.sheetResult != null) {
            properties.put("sheetResult", this.sheetResult);
        }
        if (this.nextTransactionId != null) {
            properties.put("nextTransactionId", this.nextTransactionId);
        }
        if (this.createdAt != null) {
            properties.put("createdAt", this.createdAt);
        }
        if (this.ttlAt != null) {
            properties.put("ttlAt", this.ttlAt);
        }

        return properties;
    }
}
