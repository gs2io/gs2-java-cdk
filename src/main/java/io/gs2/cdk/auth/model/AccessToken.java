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
package io.gs2.cdk.auth.model;
import io.gs2.cdk.auth.model.options.AccessTokenOptions;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class AccessToken {
    private String ownerId;
    private String userId;
    private String realUserId;
    private Long expire;
    private Integer timeOffset;
    private String federationFromUserId = null;
    private String federationPolicyDocument = null;

    public AccessToken(
        String ownerId,
        String userId,
        String realUserId,
        Long expire,
        Integer timeOffset,
        AccessTokenOptions options
    ) {
        this.ownerId = ownerId;
        this.userId = userId;
        this.realUserId = realUserId;
        this.expire = expire;
        this.timeOffset = timeOffset;
        this.federationFromUserId = options.federationFromUserId;
        this.federationPolicyDocument = options.federationPolicyDocument;
    }
    public AccessToken(
        String ownerId,
        String userId,
        String realUserId,
        Long expire,
        Integer timeOffset
    ) {
        this.ownerId = ownerId;
        this.userId = userId;
        this.realUserId = realUserId;
        this.expire = expire;
        this.timeOffset = timeOffset;
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.ownerId != null) {
            properties.put("ownerId", this.ownerId);
        }
        if (this.userId != null) {
            properties.put("userId", this.userId);
        }
        if (this.realUserId != null) {
            properties.put("realUserId", this.realUserId);
        }
        if (this.federationFromUserId != null) {
            properties.put("federationFromUserId", this.federationFromUserId);
        }
        if (this.federationPolicyDocument != null) {
            properties.put("federationPolicyDocument", this.federationPolicyDocument);
        }
        if (this.expire != null) {
            properties.put("expire", this.expire);
        }
        if (this.timeOffset != null) {
            properties.put("timeOffset", this.timeOffset);
        }

        return properties;
    }
}
