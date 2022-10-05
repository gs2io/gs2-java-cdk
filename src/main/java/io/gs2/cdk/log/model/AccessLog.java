/*
 * Copyright 2016 Game Server Services, Inc. or its affiliates. All Rights
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

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.log.resource.*;

import java.util.*;
import java.util.stream.*;

public class AccessLog {
	public Long timestamp;
	public String requestId;
	public String service;
	public String method;
	public String userId;
	public String request;
	public String result;

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

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.timestamp != null) {
            properties.put("Timestamp", this.timestamp);
        }
        if (this.requestId != null) {
            properties.put("RequestId", this.requestId);
        }
        if (this.service != null) {
            properties.put("Service", this.service);
        }
        if (this.method != null) {
            properties.put("Method", this.method);
        }
        if (this.userId != null) {
            properties.put("UserId", this.userId);
        }
        if (this.request != null) {
            properties.put("Request", this.request);
        }
        if (this.result != null) {
            properties.put("Result", this.result);
        }
        return properties;
    }
}
