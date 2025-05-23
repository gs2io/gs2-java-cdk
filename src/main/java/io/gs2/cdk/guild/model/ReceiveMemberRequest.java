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
package io.gs2.cdk.guild.model;
import io.gs2.cdk.guild.model.options.ReceiveMemberRequestOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class ReceiveMemberRequest {
    private String userId;
    private String targetGuildName;
    private String metadata = null;

    public ReceiveMemberRequest(
        String userId,
        String targetGuildName,
        ReceiveMemberRequestOptions options
    ) {
        this.userId = userId;
        this.targetGuildName = targetGuildName;
        this.metadata = options.metadata;
    }
    public ReceiveMemberRequest(
        String userId,
        String targetGuildName
    ) {
        this.userId = userId;
        this.targetGuildName = targetGuildName;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.userId != null) {
            properties.put("userId", this.userId);
        }
        if (this.targetGuildName != null) {
            properties.put("targetGuildName", this.targetGuildName);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }

        return properties;
    }
}
