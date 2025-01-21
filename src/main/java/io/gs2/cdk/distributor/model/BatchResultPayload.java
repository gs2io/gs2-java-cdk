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
import io.gs2.cdk.distributor.model.options.BatchResultPayloadOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BatchResultPayload {
    private String requestId;
    private Integer statusCode;
    private String resultPayload;

    public BatchResultPayload(
        String requestId,
        Integer statusCode,
        String resultPayload,
        BatchResultPayloadOptions options
    ) {
        this.requestId = requestId;
        this.statusCode = statusCode;
        this.resultPayload = resultPayload;
    }
    public BatchResultPayload(
        String requestId,
        Integer statusCode,
        String resultPayload
    ) {
        this.requestId = requestId;
        this.statusCode = statusCode;
        this.resultPayload = resultPayload;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.requestId != null) {
            properties.put("requestId", this.requestId);
        }
        if (this.statusCode != null) {
            properties.put("statusCode", this.statusCode);
        }
        if (this.resultPayload != null) {
            properties.put("resultPayload", this.resultPayload);
        }

        return properties;
    }
}
