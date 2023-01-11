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
import io.gs2.cdk.matchmaking.model.Player;
import io.gs2.cdk.matchmaking.model.options.CapacityOfRoleOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class CapacityOfRole {
    private String roleName;
    private Integer capacity;
    private List<String> roleAliases = null;
    private List<Player> participants = null;

    public CapacityOfRole(
        String roleName,
        Integer capacity,
        CapacityOfRoleOptions options
    ) {
        this.roleName = roleName;
        this.capacity = capacity;
        this.roleAliases = options.roleAliases;
        this.participants = options.participants;
    }
    public CapacityOfRole(
        String roleName,
        Integer capacity
    ) {
        this.roleName = roleName;
        this.capacity = capacity;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.roleName != null) {
            properties.put("roleName", this.roleName);
        }
        if (this.roleAliases != null) {
            properties.put("roleAliases", this.roleAliases);
        }
        if (this.capacity != null) {
            properties.put("capacity", this.capacity);
        }
        if (this.participants != null) {
            properties.put("participants", this.participants.stream().map(v -> v.properties(
                    )).collect(Collectors.toList()));
        }

        return properties;
    }
}
