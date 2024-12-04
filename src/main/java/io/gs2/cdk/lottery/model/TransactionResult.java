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
package io.gs2.cdk.lottery.model;
import io.gs2.cdk.lottery.model.VerifyActionResult;
import io.gs2.cdk.lottery.model.ConsumeActionResult;
import io.gs2.cdk.lottery.model.AcquireActionResult;
import io.gs2.cdk.lottery.model.options.TransactionResultOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionResult {
    private String transactionId;
    private List<VerifyActionResult> verifyResults = null;
    private List<ConsumeActionResult> consumeResults = null;
    private List<AcquireActionResult> acquireResults = null;

    public TransactionResult(
        String transactionId,
        TransactionResultOptions options
    ) {
        this.transactionId = transactionId;
        this.verifyResults = options.verifyResults;
        this.consumeResults = options.consumeResults;
        this.acquireResults = options.acquireResults;
    }
    public TransactionResult(
        String transactionId
    ) {
        this.transactionId = transactionId;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.transactionId != null) {
            properties.put("transactionId", this.transactionId);
        }
        if (this.verifyResults != null) {
            properties.put("verifyResults", this.verifyResults.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.consumeResults != null) {
            properties.put("consumeResults", this.consumeResults.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.acquireResults != null) {
            properties.put("acquireResults", this.acquireResults.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
