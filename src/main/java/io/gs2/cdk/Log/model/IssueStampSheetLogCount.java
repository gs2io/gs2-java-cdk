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
import io.gs2.cdk.log.model.options.IssueStampSheetLogCountOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class IssueStampSheetLogCount {
    private Long count;
    private String service = null;
    private String method = null;
    private String userId = null;
    private String action = null;

    public IssueStampSheetLogCount(
        Long count,
        IssueStampSheetLogCountOptions options
    ) {
        this.count = count;
        this.service = options.service;
        this.method = options.method;
        this.userId = options.userId;
        this.action = options.action;
    }
    public IssueStampSheetLogCount(
        Long count
    ) {
        this.count = count;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.service != null) {
            properties.put("service", this.service);
        }
        if (this.method != null) {
            properties.put("method", this.method);
        }
        if (this.userId != null) {
            properties.put("userId", this.userId);
        }
        if (this.action != null) {
            properties.put("action", this.action);
        }
        if (this.count != null) {
            properties.put("count", this.count);
        }

        return properties;
    }
}
