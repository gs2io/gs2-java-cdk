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
package io.gs2.cdk.stateMachine.model;
import io.gs2.cdk.stateMachine.model.options.ConsumeActionResultOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ConsumeActionResult {
    private String action;
    private String consumeRequest;
    private Integer statusCode = null;
    private String consumeResult = null;

    public ConsumeActionResult(
        String action,
        String consumeRequest,
        ConsumeActionResultOptions options
    ) {
        this.action = action;
        this.consumeRequest = consumeRequest;
        this.statusCode = options.statusCode;
        this.consumeResult = options.consumeResult;
    }
    public ConsumeActionResult(
        String action,
        String consumeRequest
    ) {
        this.action = action;
        this.consumeRequest = consumeRequest;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.action != null) {
            properties.put("action", this.action);
        }
        if (this.consumeRequest != null) {
            properties.put("consumeRequest", this.consumeRequest);
        }
        if (this.statusCode != null) {
            properties.put("statusCode", this.statusCode);
        }
        if (this.consumeResult != null) {
            properties.put("consumeResult", this.consumeResult);
        }

        return properties;
    }
}
