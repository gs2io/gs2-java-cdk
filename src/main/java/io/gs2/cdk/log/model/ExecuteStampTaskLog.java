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

public class ExecuteStampTaskLog {
	public Long timestamp;
	public String taskId;
	public String service;
	public String method;
	public String userId;
	public String action;
	public String args;

    public ExecuteStampTaskLog(
            Long timestamp,
            String taskId,
            String service,
            String method,
            String userId,
            String action,
            String args
    ) {
        this.timestamp = timestamp;
        this.taskId = taskId;
        this.service = service;
        this.method = method;
        this.userId = userId;
        this.action = action;
        this.args = args;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.timestamp != null) {
            properties.put("Timestamp", this.timestamp);
        }
        if (this.taskId != null) {
            properties.put("TaskId", this.taskId);
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
        if (this.action != null) {
            properties.put("Action", this.action);
        }
        if (this.args != null) {
            properties.put("Args", this.args);
        }
        return properties;
    }
}
