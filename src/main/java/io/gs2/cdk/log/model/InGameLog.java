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
import io.gs2.cdk.log.model.InGameLogTag;
import io.gs2.cdk.log.model.options.InGameLogOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class InGameLog {
    private Long timestamp;
    private String requestId;
    private String payload;
    private String userId = null;
    private List<InGameLogTag> tags = null;

    public InGameLog(
        Long timestamp,
        String requestId,
        String payload,
        InGameLogOptions options
    ) {
        this.timestamp = timestamp;
        this.requestId = requestId;
        this.payload = payload;
        this.userId = options.userId;
        this.tags = options.tags;
    }
    public InGameLog(
        Long timestamp,
        String requestId,
        String payload
    ) {
        this.timestamp = timestamp;
        this.requestId = requestId;
        this.payload = payload;
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
        if (this.userId != null) {
            properties.put("userId", this.userId);
        }
        if (this.tags != null) {
            properties.put("tags", this.tags.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.payload != null) {
            properties.put("payload", this.payload);
        }

        return properties;
    }
}
