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
package io.gs2.cdk.serialKey.model;
import io.gs2.cdk.serialKey.model.options.IssueJobOptions;
import io.gs2.cdk.serialKey.model.enums.IssueJobStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class IssueJob {
    private String name;
    private Integer issuedCount;
    private Integer issueRequestCount;
    private IssueJobStatus status;
    private String metadata = null;

    public IssueJob(
        String name,
        Integer issuedCount,
        Integer issueRequestCount,
        IssueJobStatus status,
        IssueJobOptions options
    ) {
        this.name = name;
        this.issuedCount = issuedCount;
        this.issueRequestCount = issueRequestCount;
        this.status = status;
        this.metadata = options.metadata;
    }
    public IssueJob(
        String name,
        Integer issuedCount,
        Integer issueRequestCount,
        IssueJobStatus status
    ) {
        this.name = name;
        this.issuedCount = issuedCount;
        this.issueRequestCount = issueRequestCount;
        this.status = status;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.name != null) {
            properties.put("name", this.name);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.issuedCount != null) {
            properties.put("issuedCount", this.issuedCount);
        }
        if (this.issueRequestCount != null) {
            properties.put("issueRequestCount", this.issueRequestCount);
        }
        if (this.status != null) {
            properties.put("status", this.status.toString(
            ));
        }

        return properties;
    }
}
