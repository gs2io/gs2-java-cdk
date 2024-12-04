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
package io.gs2.cdk.seasonRating.model;
import io.gs2.cdk.seasonRating.model.options.AcquireActionResultOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AcquireActionResult {
    private String action;
    private String acquireRequest;
    private Integer statusCode = null;
    private String acquireResult = null;

    public AcquireActionResult(
        String action,
        String acquireRequest,
        AcquireActionResultOptions options
    ) {
        this.action = action;
        this.acquireRequest = acquireRequest;
        this.statusCode = options.statusCode;
        this.acquireResult = options.acquireResult;
    }
    public AcquireActionResult(
        String action,
        String acquireRequest
    ) {
        this.action = action;
        this.acquireRequest = acquireRequest;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.action != null) {
            properties.put("action", this.action);
        }
        if (this.acquireRequest != null) {
            properties.put("acquireRequest", this.acquireRequest);
        }
        if (this.statusCode != null) {
            properties.put("statusCode", this.statusCode);
        }
        if (this.acquireResult != null) {
            properties.put("acquireResult", this.acquireResult);
        }

        return properties;
    }
}
