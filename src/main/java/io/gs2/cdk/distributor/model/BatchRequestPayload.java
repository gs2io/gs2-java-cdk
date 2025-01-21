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
import io.gs2.cdk.distributor.model.options.BatchRequestPayloadOptions;
import io.gs2.cdk.distributor.model.enums.BatchRequestPayloadService;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class BatchRequestPayload {
    private String requestId;
    private BatchRequestPayloadService service;
    private String methodName;
    private String parameter;

    public BatchRequestPayload(
        String requestId,
        BatchRequestPayloadService service,
        String methodName,
        String parameter,
        BatchRequestPayloadOptions options
    ) {
        this.requestId = requestId;
        this.service = service;
        this.methodName = methodName;
        this.parameter = parameter;
    }
    public BatchRequestPayload(
        String requestId,
        BatchRequestPayloadService service,
        String methodName,
        String parameter
    ) {
        this.requestId = requestId;
        this.service = service;
        this.methodName = methodName;
        this.parameter = parameter;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.requestId != null) {
            properties.put("requestId", this.requestId);
        }
        if (this.service != null) {
            properties.put("service", this.service.toString(
            ));
        }
        if (this.methodName != null) {
            properties.put("methodName", this.methodName);
        }
        if (this.parameter != null) {
            properties.put("parameter", this.parameter);
        }

        return properties;
    }
}
