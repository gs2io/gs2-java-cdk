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
package io.gs2.cdk.distributor.model.options;
import io.gs2.cdk.core.model.ConsumeAction;
import io.gs2.cdk.core.model.AcquireAction;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class StampSheetResultOptions {
    public List<ConsumeAction> taskRequests;
    public List<Integer> taskResultCodes;
    public List<String> taskResults;
    public Integer sheetResultCode;
    public String sheetResult;
    public String nextTransactionId;
    public Long revision;
    
    public StampSheetResultOptions withTaskRequests(
        List<ConsumeAction> taskRequests
    ) {
        this.taskRequests = taskRequests;
        return this;
    }
    
    public StampSheetResultOptions withTaskResultCodes(
        List<Integer> taskResultCodes
    ) {
        this.taskResultCodes = taskResultCodes;
        return this;
    }
    
    public StampSheetResultOptions withTaskResults(
        List<String> taskResults
    ) {
        this.taskResults = taskResults;
        return this;
    }
    
    public StampSheetResultOptions withSheetResultCode(
        Integer sheetResultCode
    ) {
        this.sheetResultCode = sheetResultCode;
        return this;
    }
    
    public StampSheetResultOptions withSheetResult(
        String sheetResult
    ) {
        this.sheetResult = sheetResult;
        return this;
    }
    
    public StampSheetResultOptions withNextTransactionId(
        String nextTransactionId
    ) {
        this.nextTransactionId = nextTransactionId;
        return this;
    }
    
    public StampSheetResultOptions withRevision(
        Long revision
    ) {
        this.revision = revision;
        return this;
    }
}

