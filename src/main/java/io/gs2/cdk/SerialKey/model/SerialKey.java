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
import io.gs2.cdk.serialKey.model.options.SerialKeyOptions;
import io.gs2.cdk.serialKey.model.options.SerialKeyStatusIsActiveOptions;
import io.gs2.cdk.serialKey.model.options.SerialKeyStatusIsUsedOptions;
import io.gs2.cdk.serialKey.model.options.SerialKeyStatusIsInactiveOptions;
import io.gs2.cdk.serialKey.model.enums.SerialKeyStatus;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.stream.Collectors;

public class SerialKey {
    private String campaignModelName;
    private String code;
    private SerialKeyStatus status;
    private Long createdAt;
    private Long updatedAt;
    private String metadata = null;
    private String usedUserId = null;
    private Long usedAt = null;

    public SerialKey(
        String campaignModelName,
        String code,
        SerialKeyStatus status,
        Long createdAt,
        Long updatedAt,
        SerialKeyOptions options
    ) {
        this.campaignModelName = campaignModelName;
        this.code = code;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.metadata = options.metadata;
        this.usedUserId = options.usedUserId;
        this.usedAt = options.usedAt;
    }
    public SerialKey(
        String campaignModelName,
        String code,
        SerialKeyStatus status,
        Long createdAt,
        Long updatedAt
    ) {
        this.campaignModelName = campaignModelName;
        this.code = code;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public static SerialKey statusIsActive(
        String campaignModelName,
        String code,
        Long createdAt,
        Long updatedAt,
        SerialKeyStatusIsActiveOptions options
    ) {
        return (new SerialKey(
            campaignModelName,
            code,
            SerialKeyStatus.ACTIVE,
            createdAt,
            updatedAt,
            new SerialKeyOptions()
                .withMetadata(options.metadata)
                .withUsedAt(options.usedAt)
        ));
    }


    public static SerialKey statusIsActive(
        String campaignModelName,
        String code,
        Long createdAt,
        Long updatedAt
    ) {
        return (new SerialKey(
            campaignModelName,
            code,
            SerialKeyStatus.ACTIVE,
            createdAt,
            updatedAt
        ));
    }

    public static SerialKey statusIsUsed(
        String campaignModelName,
        String code,
        Long createdAt,
        Long updatedAt,
        String usedUserId,
        SerialKeyStatusIsUsedOptions options
    ) {
        return (new SerialKey(
            campaignModelName,
            code,
            SerialKeyStatus.USED,
            createdAt,
            updatedAt,
            new SerialKeyOptions()
                .withUsedUserId(usedUserId)
                .withMetadata(options.metadata)
                .withUsedAt(options.usedAt)
        ));
    }


    public static SerialKey statusIsUsed(
        String campaignModelName,
        String code,
        Long createdAt,
        Long updatedAt,
        String usedUserId
    ) {
        return (new SerialKey(
            campaignModelName,
            code,
            SerialKeyStatus.USED,
            createdAt,
            updatedAt
        ));
    }

    public static SerialKey statusIsInactive(
        String campaignModelName,
        String code,
        Long createdAt,
        Long updatedAt,
        SerialKeyStatusIsInactiveOptions options
    ) {
        return (new SerialKey(
            campaignModelName,
            code,
            SerialKeyStatus.INACTIVE,
            createdAt,
            updatedAt,
            new SerialKeyOptions()
                .withMetadata(options.metadata)
                .withUsedAt(options.usedAt)
        ));
    }


    public static SerialKey statusIsInactive(
        String campaignModelName,
        String code,
        Long createdAt,
        Long updatedAt
    ) {
        return (new SerialKey(
            campaignModelName,
            code,
            SerialKeyStatus.INACTIVE,
            createdAt,
            updatedAt
        ));
    }

    public Map<String, Object> properties(
    ) {
        var properties = new HashMap<String, Object>();

        if (this.campaignModelName != null) {
            properties.put("campaignModelName", this.campaignModelName);
        }
        if (this.code != null) {
            properties.put("code", this.code);
        }
        if (this.metadata != null) {
            properties.put("metadata", this.metadata);
        }
        if (this.status != null) {
            properties.put("status", this.status.toString(
            ));
        }
        if (this.usedUserId != null) {
            properties.put("usedUserId", this.usedUserId);
        }
        if (this.createdAt != null) {
            properties.put("createdAt", this.createdAt);
        }
        if (this.usedAt != null) {
            properties.put("usedAt", this.usedAt);
        }
        if (this.updatedAt != null) {
            properties.put("updatedAt", this.updatedAt);
        }

        return properties;
    }
}
