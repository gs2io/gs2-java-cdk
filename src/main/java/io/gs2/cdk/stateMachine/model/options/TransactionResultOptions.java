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
package io.gs2.cdk.stateMachine.model.options;
import io.gs2.cdk.stateMachine.model.VerifyActionResult;
import io.gs2.cdk.stateMachine.model.ConsumeActionResult;
import io.gs2.cdk.stateMachine.model.AcquireActionResult;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionResultOptions {
    public List<VerifyActionResult> verifyResults;
    public List<ConsumeActionResult> consumeResults;
    public List<AcquireActionResult> acquireResults;
    
    public TransactionResultOptions withVerifyResults(
        List<VerifyActionResult> verifyResults
    ) {
        this.verifyResults = verifyResults;
        return this;
    }
    
    public TransactionResultOptions withConsumeResults(
        List<ConsumeActionResult> consumeResults
    ) {
        this.consumeResults = consumeResults;
        return this;
    }
    
    public TransactionResultOptions withAcquireResults(
        List<AcquireActionResult> acquireResults
    ) {
        this.acquireResults = acquireResults;
        return this;
    }
}

