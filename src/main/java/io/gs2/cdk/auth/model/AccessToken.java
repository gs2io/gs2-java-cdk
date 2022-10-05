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

package io.gs2.cdk.auth.model;

import io.gs2.cdk.core.model.*;
import io.gs2.cdk.auth.resource.*;

import java.util.*;
import java.util.stream.*;

public class AccessToken {
	public String ownerId;
	public String token;
	public String userId;
	public Long expire;
	public Integer timeOffset;

    public AccessToken(
            String ownerId,
            String token,
            String userId,
            Long expire,
            Integer timeOffset
    ) {
        this.ownerId = ownerId;
        this.token = token;
        this.userId = userId;
        this.expire = expire;
        this.timeOffset = timeOffset;
    }

    public Map<String, Object> properties() {
        var properties = new HashMap<String, Object>();
        if (this.ownerId != null) {
            properties.put("OwnerId", this.ownerId);
        }
        if (this.token != null) {
            properties.put("Token", this.token);
        }
        if (this.userId != null) {
            properties.put("UserId", this.userId);
        }
        if (this.expire != null) {
            properties.put("Expire", this.expire);
        }
        if (this.timeOffset != null) {
            properties.put("TimeOffset", this.timeOffset);
        }
        return properties;
    }
}
