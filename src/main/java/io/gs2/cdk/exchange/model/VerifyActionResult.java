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
package io.gs2.cdk.exchange.model;
import io.gs2.cdk.exchange.model.options.VerifyActionResultOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class VerifyActionResult {
    private String action;
    private String verifyRequest;
    private Integer statusCode = null;
    private String verifyResult = null;

    public VerifyActionResult(
        String action,
        String verifyRequest,
        VerifyActionResultOptions options
    ) {
        this.action = action;
        this.verifyRequest = verifyRequest;
        this.statusCode = options.statusCode;
        this.verifyResult = options.verifyResult;
    }
    public VerifyActionResult(
        String action,
        String verifyRequest
    ) {
        this.action = action;
        this.verifyRequest = verifyRequest;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.action != null) {
            properties.put("action", this.action);
        }
        if (this.verifyRequest != null) {
            properties.put("verifyRequest", this.verifyRequest);
        }
        if (this.statusCode != null) {
            properties.put("statusCode", this.statusCode);
        }
        if (this.verifyResult != null) {
            properties.put("verifyResult", this.verifyResult);
        }

        return properties;
    }
}
