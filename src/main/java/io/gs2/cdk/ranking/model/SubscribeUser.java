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

package io.gs2.cdk.ranking.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.ranking.resource.*;

import java.util.*;
import java.util.stream.*;

public class SubscribeUser {
	public String categoryName;
	public String userId;
	public String targetUserId;

    public SubscribeUser(
            String categoryName,
            String userId,
            String targetUserId
    ) {
        this.categoryName = categoryName;
        this.userId = userId;
        this.targetUserId = targetUserId;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.categoryName != null) {
            properties.put("CategoryName", this.categoryName);
        }
        if (this.userId != null) {
            properties.put("UserId", this.userId);
        }
        if (this.targetUserId != null) {
            properties.put("TargetUserId", this.targetUserId);
        }
        return properties;
    }
}
