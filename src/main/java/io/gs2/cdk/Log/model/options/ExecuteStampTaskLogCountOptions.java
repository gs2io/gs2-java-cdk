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
package io.gs2.cdk.log.model.options;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ExecuteStampTaskLogCountOptions {
    public String service;
    public String method;
    public String userId;
    public String action;
    
    public ExecuteStampTaskLogCountOptions withService(
        String service
    ) {
        this.service = service;
        return this;
    }
    
    public ExecuteStampTaskLogCountOptions withMethod(
        String method
    ) {
        this.method = method;
        return this;
    }
    
    public ExecuteStampTaskLogCountOptions withUserId(
        String userId
    ) {
        this.userId = userId;
        return this;
    }
    
    public ExecuteStampTaskLogCountOptions withAction(
        String action
    ) {
        this.action = action;
        return this;
    }
}

