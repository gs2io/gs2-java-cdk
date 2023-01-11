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
package io.gs2.cdk.log.model;
import io.gs2.cdk.log.model.options.AccessLogOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AccessLog {
    private Long timestamp;
    private String requestId;
    private String service;
    private String method;
    private String request;
    private String result;
    private String userId = null;

    public AccessLog(
        Long timestamp,
        String requestId,
        String service,
        String method,
        String request,
        String result,
        AccessLogOptions options
    ) {
        this.timestamp = timestamp;
        this.requestId = requestId;
        this.service = service;
        this.method = method;
        this.request = request;
        this.result = result;
        this.userId = options.userId;
    }
    public AccessLog(
        Long timestamp,
        String requestId,
        String service,
        String method,
        String request,
        String result
    ) {
        this.timestamp = timestamp;
        this.requestId = requestId;
        this.service = service;
        this.method = method;
        this.request = request;
        this.result = result;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.timestamp != null) {
            properties.put("timestamp", this.timestamp);
        }
        if (this.requestId != null) {
            properties.put("requestId", this.requestId);
        }
        if (this.service != null) {
            properties.put("service", this.service);
        }
        if (this.method != null) {
            properties.put("method", this.method);
        }
        if (this.userId != null) {
            properties.put("userId", this.userId);
        }
        if (this.request != null) {
            properties.put("request", this.request);
        }
        if (this.result != null) {
            properties.put("result", this.result);
        }

        return properties;
    }
}
