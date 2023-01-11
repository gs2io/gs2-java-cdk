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
package io.gs2.cdk.inbox.model;
import io.gs2.cdk.core.model.AcquireAction;
import io.gs2.cdk.inbox.model.TimeSpan;
import io.gs2.cdk.inbox.model.options.GlobalMessageOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class GlobalMessage {
    private String name;
    private String metadata;
    private List<AcquireAction> readAcquireActions = null;
    private TimeSpan expiresTimeSpan = null;
    private Long expiresAt = null;

    public GlobalMessage(
        String name,
        String metadata,
        GlobalMessageOptions options
    ) {
        this.name = name;
        this.metadata = metadata;
        this.readAcquireActions = options.readAcquireActions;
        this.expiresTimeSpan = options.expiresTimeSpan;
        this.expiresAt = options.expiresAt;
    }
    public GlobalMessage(
        String name,
        String metadata
    ) {
        this.name = name;
        this.metadata = metadata;
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
        if (this.readAcquireActions != null) {
            properties.put("readAcquireActions", this.readAcquireActions.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.expiresTimeSpan != null) {
            properties.put("expiresTimeSpan", this.expiresTimeSpan.properties(
            ));
        }
        if (this.expiresAt != null) {
            properties.put("expiresAt", this.expiresAt);
        }

        return properties;
    }
}
