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
package io.gs2.cdk.matchmaking.model;
import io.gs2.cdk.matchmaking.model.Attribute;
import io.gs2.cdk.matchmaking.model.options.PlayerOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class Player {
    private String userId;
    private String roleName;
    private List<Attribute> attributes = null;
    private List<String> denyUserIds = null;

    public Player(
        String userId,
        String roleName,
        PlayerOptions options
    ) {
        this.userId = userId;
        this.roleName = roleName;
        this.attributes = options.attributes;
        this.denyUserIds = options.denyUserIds;
    }
    public Player(
        String userId,
        String roleName
    ) {
        this.userId = userId;
        this.roleName = roleName;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.userId != null) {
            properties.put("userId", this.userId);
        }
        if (this.attributes != null) {
            properties.put("attributes", this.attributes.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }
        if (this.roleName != null) {
            properties.put("roleName", this.roleName);
        }
        if (this.denyUserIds != null) {
            properties.put("denyUserIds", this.denyUserIds);
        }

        return properties;
    }
}
