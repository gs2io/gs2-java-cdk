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
import io.gs2.cdk.log.model.options.AccessLogWithTelemetryOptions;
import io.gs2.cdk.log.model.enums.AccessLogWithTelemetryStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AccessLogWithTelemetry {
    private Long timestamp;
    private String sourceRequestId;
    private String requestId;
    private Long duration;
    private String service;
    private String method;
    private String request;
    private String result;
    private AccessLogWithTelemetryStatus status;
    private String userId = null;

    public AccessLogWithTelemetry(
        Long timestamp,
        String sourceRequestId,
        String requestId,
        Long duration,
        String service,
        String method,
        String request,
        String result,
        AccessLogWithTelemetryStatus status,
        AccessLogWithTelemetryOptions options
    ) {
        this.timestamp = timestamp;
        this.sourceRequestId = sourceRequestId;
        this.requestId = requestId;
        this.duration = duration;
        this.service = service;
        this.method = method;
        this.request = request;
        this.result = result;
        this.status = status;
        this.userId = options.userId;
    }
    public AccessLogWithTelemetry(
        Long timestamp,
        String sourceRequestId,
        String requestId,
        Long duration,
        String service,
        String method,
        String request,
        String result,
        AccessLogWithTelemetryStatus status
    ) {
        this.timestamp = timestamp;
        this.sourceRequestId = sourceRequestId;
        this.requestId = requestId;
        this.duration = duration;
        this.service = service;
        this.method = method;
        this.request = request;
        this.result = result;
        this.status = status;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.timestamp != null) {
            properties.put("timestamp", this.timestamp);
        }
        if (this.sourceRequestId != null) {
            properties.put("sourceRequestId", this.sourceRequestId);
        }
        if (this.requestId != null) {
            properties.put("requestId", this.requestId);
        }
        if (this.duration != null) {
            properties.put("duration", this.duration);
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
        if (this.status != null) {
            properties.put("status", this.status.toString(
            ));
        }

        return properties;
    }
}
