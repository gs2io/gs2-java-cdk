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

package io.gs2.cdk.matchmaking.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.matchmaking.resource.*;

import java.util.*;
import java.util.stream.*;

public class CapacityOfRole {
	public String roleName;
	public List<String> roleAliases;
	public Integer capacity;
	public List<Player> participants;

    public CapacityOfRole(
            String roleName,
            Integer capacity
    ) {
        this.roleName = roleName;
        this.capacity = capacity;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.roleName != null) {
            properties.put("RoleName", this.roleName);
        }
        if (this.roleAliases != null) {
            properties.put("RoleAliases", this.roleAliases);
        }
        if (this.capacity != null) {
            properties.put("Capacity", this.capacity);
        }
        if (this.participants != null) {
            properties.put("Participants", this.participants.stream().map(Player::properties).collect(Collectors.toList()));
        }
        return properties;
    }
}
